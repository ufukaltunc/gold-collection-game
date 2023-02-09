package com.mycompany.altintoplama;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Altin extends JPanel implements KeyListener, ActionListener {

    private boolean play = true;
    public MapGenerator map;
    public int Satir;
    public int Sutun;
    public int toplamaltin;
    public int gizlialtin;
    public Timer timer;
    public int delay;
    public Oyuncu a;
    public Oyuncu b;
    public Oyuncu c;
    public Oyuncu d;
    public int width;
    public int height;
    public int temp = 0;
    public int hamlesayisi;
    public int aradakisatir;
    public int aradakisutun;
    public int altinsayi;
    public int gizlisayi;
    public int a_hamlesayisi;
    public int b_hamlesayisi;
    public int c_hamlesayisi;
    public int d_hamlesayisi;
    public int a_aradakisatir;
    public int a_aradakisutun;
    public int b_aradakisatir;
    public int b_aradakisutun;
    public int c_aradakisatir;
    public int c_aradakisutun;
    public int d_aradakisatir;
    public int d_aradakisutun;
    public String aninaltin;
    public String bninaltin;
    public String cninaltin;
    public String dninaltin;
    public int ak = 0;
    public int bk = 0;
    public int ck = 0;
    public int dk = 0;
    public File file_a;
    public File file_b;
    public File file_c;
    public File file_d;

    public Altin(int satir, int sutun, int toplamaltin, int gizlialtin, Oyuncu[] oyunculiste, int Delay) {
        this.Satir = satir;
        this.Sutun = sutun;
        this.toplamaltin = toplamaltin;
        this.gizlialtin = gizlialtin;
        this.a = oyunculiste[0];
        this.b = oyunculiste[1];
        this.c = oyunculiste[2];
        this.d = oyunculiste[3];
        this.width = 1280 / Sutun;
        this.height = 790 / Satir;
        this.delay = Delay;
        map = new MapGenerator(satir, sutun, toplamaltin, gizlialtin, oyunculiste);
        timer = new Timer(delay, this);
        timer.start();
        altinsayi = Satir * Sutun;
        altinsayi *= toplamaltin;
        altinsayi /= 100;

        gizlisayi = altinsayi * gizlialtin;
        gizlisayi /= 100;
        altinsayi -= gizlisayi;

        if (a.getHamlemaliyet() > a.getHedefmaliyet()) {
            ak = a.getHamlemaliyet();
        } else if (a.getHamlemaliyet() <= a.getHedefmaliyet()) {
            ak = a.getHedefmaliyet();
        }
        if (b.getHamlemaliyet() > b.getHedefmaliyet()) {
            bk = b.getHamlemaliyet();
        } else if (b.getHamlemaliyet() <= b.getHedefmaliyet()) {
            bk = b.getHedefmaliyet();
        }
        if (c.getHamlemaliyet() > c.getHedefmaliyet()) {
            ck = c.getHamlemaliyet();
        } else if (c.getHamlemaliyet() <= c.getHedefmaliyet()) {
            ck = c.getHedefmaliyet();
        }
        if (d.getHamlemaliyet() > d.getHedefmaliyet()) {
            dk = d.getHamlemaliyet();
        } else if (d.getHamlemaliyet() <= d.getHedefmaliyet()) {
            dk = d.getHedefmaliyet();
        }

        file_a = new File("a_adimlar.txt");
        if (!file_a.exists()) {
            try {
                file_a.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (file_a.exists()) {
            file_a.delete(); 
        }
        file_b = new File("b_adimlar.txt");
        if (!file_b.exists()) {
            try {
                file_b.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (file_b.exists()) {
            file_b.delete(); 
        }
        file_c = new File("c_adimlar.txt");
        if (!file_c.exists()) {
            try {
                file_c.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (file_c.exists()) {
            file_c.delete(); 
        }
        file_d = new File("d_adimlar.txt");
        if (!file_d.exists()) {
            try {
                file_d.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (file_d.exists()) {
            file_d.delete(); 
        }
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public Altin() {
    }

    public int getToplamaltin() {
        return toplamaltin;
    }

    public void setToplamaltin(int normalaltin) {
        this.toplamaltin = normalaltin;
    }

    public int getGizlialtin() {
        return gizlialtin;
    }

    public void setGizlialtin(int gizlialtin) {
        this.gizlialtin = gizlialtin;
    }

    public int getSatir() {
        return Satir;
    }

    public void setSatir(int satir) {
        this.Satir = satir;
    }

    public int getSutun() {
        return Sutun;
    }

    public void setSutun(int sutun) {
        this.Sutun = sutun;
    }

    public void paint(Graphics g) {

        aninaltin = String.valueOf(a.getAltinmiktar());
        bninaltin = String.valueOf(b.getAltinmiktar());
        cninaltin = String.valueOf(c.getAltinmiktar());
        dninaltin = String.valueOf(d.getAltinmiktar());

        map.draw((Graphics2D) g);

        g.setColor(Color.BLACK);
        g.fillOval(a.getoyuncuSutun() * width + 5, a.getoyuncuSatir() * height + 5, 15, 15);
        g.setColor(Color.BLUE);
        g.fillOval(b.getoyuncuSutun() * width + 5, b.getoyuncuSatir() * height + 5, 15, 15);
        g.setColor(Color.CYAN);
        g.fillOval(c.getoyuncuSutun() * width + 5, c.getoyuncuSatir() * height + 5, 15, 15);
        g.setColor(Color.MAGENTA);
        g.fillOval(d.getoyuncuSutun() * width + 5, d.getoyuncuSatir() * height + 5, 15, 15);

        g.setColor(Color.BLACK);
        g.fillOval(1315, 100, 40, 40);
        g.setColor(Color.white);
        g.setFont(new Font("Arial Black", Font.BOLD, 20));
        g.drawString("A", 1331, 123);

        g.setColor(Color.BLUE);
        g.fillOval(1315, 175, 40, 40);
        g.setColor(Color.white);
        g.drawString("B", 1331, 198);

        g.setColor(Color.CYAN);
        g.fillOval(1315, 250, 40, 40);
        g.setColor(Color.white);
        g.drawString("C", 1331, 273);

        g.setColor(Color.MAGENTA);
        g.fillOval(1315, 325, 40, 40);
        g.setColor(Color.white);
        g.drawString("D", 1331, 348);

        g.setFont(new Font("Arial Black", Font.ITALIC, 20));
        g.setColor(Color.white);
        g.fillRect(1381, 80, 50, 50);
        g.setColor(Color.black);
        g.drawString(aninaltin, 1380, 125);

        g.setFont(new Font("Arial Black", Font.ITALIC, 20));
        g.setColor(Color.white);
        g.fillRect(1381, 155, 50, 50);
        g.setColor(Color.BLUE);
        g.drawString(bninaltin, 1380, 200);

        g.setFont(new Font("Arial Black", Font.ITALIC, 20));
        g.setColor(Color.white);
        g.fillRect(1381, 230, 50, 50);
        g.setColor(Color.CYAN);
        g.drawString(cninaltin, 1380, 275);

        g.setFont(new Font("Arial Black", Font.ITALIC, 20));
        g.setColor(Color.white);
        g.fillRect(1381, 305, 50, 50);
        g.setColor(Color.MAGENTA);
        g.drawString(dninaltin, 1380, 350);

        if (a.getAltinmiktar() < ak && b.getAltinmiktar() < bk && c.getAltinmiktar() < ck && d.getAltinmiktar() < dk) {
            g.setFont(new Font("Arial Black", Font.ITALIC, 50));
            g.setColor(Color.red);
            g.drawString("TÜM OYUNCULARIN ALTINI BİTTİ", 100, 150);

        }
        if (altinsayi <= 0) {
            g.setFont(new Font("Arial Black", Font.ITALIC, 50));
            g.setColor(Color.red);
            g.drawString("TAHTADAKİ TÜM ALTINLAR TOPLANDI", 100, 150);
        }
        g.dispose();
    }

    public void sagaKaydir(Oyuncu oyuncu) {
        timer.start();

        if (play) {

            oyuncu.setoyuncuSutun(oyuncu.getoyuncuSutun() + 1);
            oyuncu.setAtilanadim(oyuncu.getAtilanadim() + 1);
            if (oyuncu.getId() == 0) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_a, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (oyuncu.getId() == 1) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_b, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (oyuncu.getId() == 2) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_c, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (oyuncu.getId() == 3) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_d, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void solaKaydir(Oyuncu oyuncu) {
        timer.start();
        if (play) {
            oyuncu.setoyuncuSutun(oyuncu.getoyuncuSutun() - 1);
            oyuncu.setAtilanadim(oyuncu.getAtilanadim() + 1);
            if (oyuncu.getId() == 0) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_a, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (oyuncu.getId() == 1) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_b, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (oyuncu.getId() == 2) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_c, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (oyuncu.getId() == 3) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_d, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void asagiKaydir(Oyuncu oyuncu) {
        timer.start();
        if (play) {
            oyuncu.setoyuncuSatir(oyuncu.getoyuncuSatir() + 1);
            oyuncu.setAtilanadim(oyuncu.getAtilanadim() + 1);
            if (oyuncu.getId() == 0) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_a, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (oyuncu.getId() == 1) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_b, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (oyuncu.getId() == 2) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_c, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (oyuncu.getId() == 3) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_d, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void yukariKaydir(Oyuncu oyuncu) {
        timer.start();
        if (play) {
            oyuncu.setoyuncuSatir(oyuncu.getoyuncuSatir() - 1);
            oyuncu.setAtilanadim(oyuncu.getAtilanadim() + 1);
            if (oyuncu.getId() == 0) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_a, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (oyuncu.getId() == 1) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_b, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (oyuncu.getId() == 2) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_c, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (oyuncu.getId() == 3) {
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(file_d, true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("[" + oyuncu.getoyuncuSatir() + "," + oyuncu.getoyuncuSutun() + "]\n");
                    bWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fileWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Altin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (timer.isRunning()) {
                timer.stop();
            } else if (!(timer.isRunning())) {
                timer.start();
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        Oyna();
        repaint();

    }

    public void Oyna() {
        if (altinsayi > 0) {
            if (a.isA_play()) {
                if (a.getA_hedefsatir() + a.getA_hedefsutun() == 0 || map.map[a.getA_hedefsatir()][a.getA_hedefsutun()] > 9) {

                    if (a.getAltinmiktar() >= a.getHedefmaliyet()) {
                        a.setAltinmiktar(a.getAltinmiktar() - a.getHedefmaliyet());
                        a.setHarcananaltin(a.getHarcananaltin() + a.getHedefmaliyet());
                        a.a_hedefbelirle(a, map);
                    }

                }

                a_aradakisatir = a.getA_hedefsatir() - a.getoyuncuSatir();
                a_aradakisutun = a.getA_hedefsutun() - a.getoyuncuSutun();
                a_hamlesayisi = a.getAdimsayisi();
                if (a.getAltinmiktar() < a.getHamlemaliyet()) {
                    a_hamlesayisi = 0;
                }
                a.setA_play(false);
            }
            if (a_hamlesayisi > 0 && temp == 0 && a.getAltinmiktar() >= 0) {
                if (a_hamlesayisi == a.getAdimsayisi()) {
                    a.setAltinmiktar(a.getAltinmiktar() - a.getHamlemaliyet());
                    a.setHarcananaltin(a.getHarcananaltin() + a.getHamlemaliyet());
                }
                a_hamlesayisi--;
                if (a_aradakisutun < 0) {
                    solaKaydir(a);
                    a_aradakisutun++;
                } else if (a_aradakisutun > 0) {
                    sagaKaydir(a);
                    a_aradakisutun--;
                } else if (a_aradakisutun == 0 && a.getoyuncuSutun() == a.getA_hedefsutun()) {
                    timer.start();
                    if (a_aradakisatir < 0) {
                        yukariKaydir(a);
                        a_aradakisatir++;
                    } else if (a_aradakisatir > 0) {
                        asagiKaydir(a);
                        a_aradakisatir--;
                    }
                }
                if (a.getoyuncuSatir() == a.getA_hedefsatir() && a.getoyuncuSutun() == a.getA_hedefsutun()) {
                    if (map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] == 2) {
                        a.setAltinmiktar(a.getAltinmiktar() + 5);
                        a.setToplananaltin(a.getToplananaltin() + 5);
                        map.map[a.getA_hedefsatir()][a.getA_hedefsutun()] = 10;
                        altinsayi--;
                        if (a.getAltinmiktar() >= a.getHedefmaliyet()) {
                            a.setAltinmiktar(a.getAltinmiktar() - a.getHedefmaliyet());
                            a.setHarcananaltin(a.getHarcananaltin() + a.getHedefmaliyet());
                            a.a_hedefbelirle(a, map);
                        }

                    }
                    if (map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] == 3) {
                        a.setAltinmiktar(a.getAltinmiktar() + 10);
                        a.setToplananaltin(a.getToplananaltin() + 10);
                        map.map[a.getA_hedefsatir()][a.getA_hedefsutun()] = 11;
                        altinsayi--;
                        if (a.getAltinmiktar() >= a.getHedefmaliyet()) {
                            a.setAltinmiktar(a.getAltinmiktar() - a.getHedefmaliyet());
                            a.setHarcananaltin(a.getHarcananaltin() + a.getHedefmaliyet());
                            a.a_hedefbelirle(a, map);
                        }
                    }
                    if (map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] == 4) {
                        a.setAltinmiktar(a.getAltinmiktar() + 15);
                        a.setToplananaltin(a.getToplananaltin() + 15);
                        map.map[a.getA_hedefsatir()][a.getA_hedefsutun()] = 12;
                        altinsayi--;
                        if (a.getAltinmiktar() >= a.getHedefmaliyet()) {
                            a.setAltinmiktar(a.getAltinmiktar() - a.getHedefmaliyet());
                            a.setHarcananaltin(a.getHarcananaltin() + a.getHedefmaliyet());
                            a.a_hedefbelirle(a, map);
                        }
                    }
                    if (map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] == 5) {
                        a.setAltinmiktar(a.getAltinmiktar() + 20);
                        a.setToplananaltin(a.getToplananaltin() + 20);
                        map.map[a.getA_hedefsatir()][a.getA_hedefsutun()] = 13;
                        altinsayi--;
                        if (a.getAltinmiktar() >= a.getHedefmaliyet()) {
                            a.setAltinmiktar(a.getAltinmiktar() - a.getHedefmaliyet());
                            a.setHarcananaltin(a.getHarcananaltin() + a.getHedefmaliyet());
                            a.a_hedefbelirle(a, map);
                        }
                    }
                    a_hamlesayisi = 0;
                }
                if (map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] >= 6 && map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] <= 9) {
                    if (map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] == 6) {
                        map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] = 2;
                        altinsayi++;
                        gizlisayi--;
                    }
                    if (map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] == 7) {
                        map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] = 3;
                        altinsayi++;
                        gizlisayi--;
                    }
                    if (map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] == 8) {
                        map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] = 4;
                        altinsayi++;
                        gizlisayi--;
                    }
                    if (map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] == 9) {
                        map.map[a.getoyuncuSatir()][a.getoyuncuSutun()] = 5;
                        altinsayi++;
                        gizlisayi--;
                    }

                }
            } else if (a_hamlesayisi == 0 && temp == 0) {
                if (b.getAltinmiktar() > 0) {
                    b.setB_play(true);
                    temp = 1;
                } else if (c.getAltinmiktar() > 0) {
                    c.setC_play(true);
                    temp = 2;

                } else if (d.getAltinmiktar() > 0) {
                    d.setD_play(true);
                    temp = 3;

                } else if (a.getAltinmiktar() > 0) {
                    a.setA_play(true);
                    temp = 0;

                }

            }
            if (b.isB_play()) {
                if (b.getB_hedefsatir() + b.getB_hedefsutun() == 0 || map.map[b.getB_hedefsatir()][b.getB_hedefsutun()] > 9) {

                    if (b.getAltinmiktar() >= b.getHedefmaliyet()) {
                        b.setAltinmiktar(b.getAltinmiktar() - b.getHedefmaliyet());
                        b.setHarcananaltin(b.getHarcananaltin() + b.getHedefmaliyet());
                        b.b_hedefbelirle(b, map);
                    }
                }

                b_aradakisatir = b.getB_hedefsatir() - b.getoyuncuSatir();
                b_aradakisutun = b.getB_hedefsutun() - b.getoyuncuSutun();
                b_hamlesayisi = b.getAdimsayisi();
                if (b.getAltinmiktar() < b.getHamlemaliyet()) {
                    b_hamlesayisi = 0;
                }
                b.setB_play(false);
            }
            if (b_hamlesayisi > 0 && temp == 1 && b.getAltinmiktar() >= 0) {
                if (b_hamlesayisi == b.getAdimsayisi()) {
                    b.setAltinmiktar(b.getAltinmiktar() - b.getHamlemaliyet());
                    b.setHarcananaltin(b.getHarcananaltin() + b.getHamlemaliyet());
                }
                b_hamlesayisi--;
                if (b_aradakisutun < 0) {
                    solaKaydir(b);
                    b_aradakisutun++;
                } else if (b_aradakisutun > 0) {
                    sagaKaydir(b);
                    b_aradakisutun--;
                } else if (b_aradakisutun == 0 && b.getoyuncuSutun() == b.getB_hedefsutun()) {
                    timer.start();
                    if (b_aradakisatir < 0) {
                        yukariKaydir(b);
                        b_aradakisatir++;
                    } else if (b_aradakisatir > 0) {
                        asagiKaydir(b);
                        b_aradakisatir--;
                    }
                }
                if (b.getoyuncuSatir() == b.getB_hedefsatir() && b.getoyuncuSutun() == b.getB_hedefsutun()) {

                    if (map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] == 2) {
                        b.setAltinmiktar(b.getAltinmiktar() + 5);
                        b.setToplananaltin(b.getToplananaltin() + 5);
                        map.map[b.getB_hedefsatir()][b.getB_hedefsutun()] = 10;
                        altinsayi--;
                        if (b.getAltinmiktar() >= b.getHedefmaliyet()) {
                            b.setAltinmiktar(b.getAltinmiktar() - b.getHedefmaliyet());
                            b.setHarcananaltin(b.getHarcananaltin() + b.getHedefmaliyet());
                            b.b_hedefbelirle(b, map);
                        }
                    }
                    if (map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] == 3) {
                        b.setAltinmiktar(b.getAltinmiktar() + 10);
                        b.setToplananaltin(b.getToplananaltin() + 10);
                        map.map[b.getB_hedefsatir()][b.getB_hedefsutun()] = 11;
                        altinsayi--;
                        if (b.getAltinmiktar() >= b.getHedefmaliyet()) {
                            b.setAltinmiktar(b.getAltinmiktar() - b.getHedefmaliyet());
                            b.setHarcananaltin(b.getHarcananaltin() + b.getHedefmaliyet());
                            b.b_hedefbelirle(b, map);
                        }
                    }
                    if (map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] == 4) {
                        b.setAltinmiktar(b.getAltinmiktar() + 15);
                        b.setToplananaltin(b.getToplananaltin() + 15);
                        map.map[b.getB_hedefsatir()][b.getB_hedefsutun()] = 12;
                        altinsayi--;
                        if (b.getAltinmiktar() >= b.getHedefmaliyet()) {
                            b.setAltinmiktar(b.getAltinmiktar() - b.getHedefmaliyet());
                            b.setHarcananaltin(b.getHarcananaltin() + b.getHedefmaliyet());
                            b.b_hedefbelirle(b, map);
                        }
                    }
                    if (map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] == 5) {
                        b.setAltinmiktar(b.getAltinmiktar() + 20);
                        b.setToplananaltin(b.getToplananaltin() + 20);
                        map.map[b.getB_hedefsatir()][b.getB_hedefsutun()] = 13;
                        altinsayi--;
                        if (b.getAltinmiktar() >= b.getHedefmaliyet()) {
                            b.setAltinmiktar(b.getAltinmiktar() - b.getHedefmaliyet());
                            b.setHarcananaltin(b.getHarcananaltin() + b.getHedefmaliyet());
                            b.b_hedefbelirle(b, map);
                        }
                    }
                    b_hamlesayisi = 0;

                }
                if (map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] >= 6 && map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] <= 9) {
                    if (map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] == 6) {
                        map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] = 2;
                        altinsayi++;
                        gizlisayi--;

                    }
                    if (map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] == 7) {
                        map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] = 3;
                        altinsayi++;
                        gizlisayi--;
                    }
                    if (map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] == 8) {
                        map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] = 4;
                        altinsayi++;
                        gizlisayi--;
                    }
                    if (map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] == 9) {
                        map.map[b.getoyuncuSatir()][b.getoyuncuSutun()] = 5;
                        altinsayi++;
                        gizlisayi--;
                    }

                }
            } else if (b_hamlesayisi == 0 && temp == 1) {
                if (c.getAltinmiktar() > 0) {
                    c.setC_play(true);
                    temp = 2;
                } else if (d.getAltinmiktar() > 0) {
                    d.setD_play(true);
                    temp = 3;

                } else if (a.getAltinmiktar() > 0) {
                    a.setA_play(true);
                    temp = 0;

                } else if (b.getAltinmiktar() > 0) {
                    b.setB_play(true);
                    temp = 1;

                }
            }
            if (c.isC_play()) {
                if (c.getC_hedefsatir() + c.getC_hedefsutun() == 0 || map.map[c.getC_hedefsatir()][c.getC_hedefsutun()] > 9) {

                    int fark = gizlisayi;
                    if (c.getAltinmiktar() >= c.getHedefmaliyet()) {
                        c.setAltinmiktar(c.getAltinmiktar() - c.getHedefmaliyet());
                        System.out.println("C +15 Ekledi");
                        c.setHarcananaltin(c.getHarcananaltin() + c.getHedefmaliyet());
                        gizlisayi = c.c_hedefbelirle(c, map, gizlisayi);
                        altinsayi += fark - gizlisayi;
                    }

                }

                c_aradakisatir = c.getC_hedefsatir() - c.getoyuncuSatir();
                c_aradakisutun = c.getC_hedefsutun() - c.getoyuncuSutun();
                c_hamlesayisi = c.getAdimsayisi();
                if (c.getAltinmiktar() < c.getHamlemaliyet()) {
                    c_hamlesayisi = 0;
                }
                c.setC_play(false);
            }
            if (c_hamlesayisi > 0 && temp == 2 && c.getAltinmiktar() >= 0) {
                if (c_hamlesayisi == c.getAdimsayisi()) {
                    c.setAltinmiktar(c.getAltinmiktar() - c.getHamlemaliyet());
                    System.out.println("C +5 Ekledi");
                    c.setHarcananaltin(c.getHarcananaltin() + c.getHamlemaliyet());
                }
                c_hamlesayisi--;
                if (c_aradakisutun < 0) {
                    solaKaydir(c);

                    c_aradakisutun++;
                } else if (c_aradakisutun > 0) {
                    sagaKaydir(c);
                    c_aradakisutun--;
                } else if (c_aradakisutun == 0 && c.getoyuncuSutun() == c.getC_hedefsutun()) {
                    timer.start();
                    if (c_aradakisatir < 0) {
                        yukariKaydir(c);
                        c_aradakisatir++;
                    } else if (c_aradakisatir > 0) {
                        asagiKaydir(c);
                        c_aradakisatir--;
                    }
                }
                if (c.getoyuncuSatir() == c.getC_hedefsatir() && c.getoyuncuSutun() == c.getC_hedefsutun()) {

                    if (map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] == 2) {
                        c.setAltinmiktar(c.getAltinmiktar() + 5);
                        c.setToplananaltin(c.getToplananaltin() + 5);
                        map.map[c.getC_hedefsatir()][c.getC_hedefsutun()] = 10;
                        altinsayi--;

                        int fark = gizlisayi;
                        if (c.getAltinmiktar() >= c.getHedefmaliyet()) {
                            c.setAltinmiktar(c.getAltinmiktar() - c.getHedefmaliyet());
                            System.out.println("C +15 Ekledi");
                            c.setHarcananaltin(c.getHarcananaltin() + c.getHedefmaliyet());
                            gizlisayi = c.c_hedefbelirle(c, map, gizlisayi);
                            altinsayi += fark - gizlisayi;
                        }

                    }
                    if (map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] == 3) {
                        c.setAltinmiktar(c.getAltinmiktar() + 10);
                        c.setToplananaltin(c.getToplananaltin() + 10);
                        map.map[c.getC_hedefsatir()][c.getC_hedefsutun()] = 11;
                        altinsayi--;

                        int fark = gizlisayi;
                        if (c.getAltinmiktar() >= c.getHedefmaliyet()) {
                            c.setAltinmiktar(c.getAltinmiktar() - c.getHedefmaliyet());
                            System.out.println("C +15 Ekledi");
                            c.setHarcananaltin(c.getHarcananaltin() + c.getHedefmaliyet());
                            gizlisayi = c.c_hedefbelirle(c, map, gizlisayi);
                            altinsayi += fark - gizlisayi;
                        }
                    }
                    if (map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] == 4) {
                        c.setAltinmiktar(c.getAltinmiktar() + 15);
                        c.setToplananaltin(c.getToplananaltin() + 15);
                        map.map[c.getC_hedefsatir()][c.getC_hedefsutun()] = 12;
                        altinsayi--;

                        int fark = gizlisayi;
                        if (c.getAltinmiktar() >= c.getHedefmaliyet()) {
                            c.setAltinmiktar(c.getAltinmiktar() - c.getHedefmaliyet());
                            System.out.println("C +15 Ekledi");
                            c.setHarcananaltin(c.getHarcananaltin() + c.getHedefmaliyet());
                            gizlisayi = c.c_hedefbelirle(c, map, gizlisayi);
                            altinsayi += fark - gizlisayi;
                        }
                    }
                    if (map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] == 5) {
                        c.setAltinmiktar(c.getAltinmiktar() + 20);
                        c.setToplananaltin(c.getToplananaltin() + 20);
                        map.map[c.getC_hedefsatir()][c.getC_hedefsutun()] = 13;
                        altinsayi--;

                        int fark = gizlisayi;
                        if (c.getAltinmiktar() >= c.getHedefmaliyet()) {
                            c.setAltinmiktar(c.getAltinmiktar() - c.getHedefmaliyet());
                            System.out.println("C +15 Ekledi");
                            c.setHarcananaltin(c.getHarcananaltin() + c.getHedefmaliyet());
                            gizlisayi = c.c_hedefbelirle(c, map, gizlisayi);
                            altinsayi += fark - gizlisayi;
                        }
                    }
                    c_hamlesayisi = 0;
                }
                if (map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] >= 6 && map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] <= 9) {
                    if (map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] == 6) {
                        map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] = 2;
                        altinsayi++;
                        gizlisayi--;

                    }
                    if (map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] == 7) {
                        map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] = 3;
                        altinsayi++;
                        gizlisayi--;
                    }
                    if (map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] == 8) {
                        map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] = 4;
                        altinsayi++;
                        gizlisayi--;
                    }
                    if (map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] == 9) {
                        map.map[c.getoyuncuSatir()][c.getoyuncuSutun()] = 5;
                        altinsayi++;
                        gizlisayi--;
                    }

                }
            } else if (c_hamlesayisi == 0 && temp == 2) {
                if (d.getAltinmiktar() > 0) {
                    d.setD_play(true);
                    temp = 3;

                } else if (a.getAltinmiktar() > 0) {
                    a.setA_play(true);
                    temp = 0;
                } else if (b.getAltinmiktar() > 0) {
                    b.setB_play(true);
                    temp = 1;

                } else if (c.getAltinmiktar() > 0) {
                    c.setC_play(true);
                    temp = 2;

                }
            }
            if (d.isD_play()) {
                if (d.getD_hedefsatir() + d.getD_hedefsutun() == 0 || map.map[d.getD_hedefsatir()][d.getD_hedefsutun()] > 9) {

                    if (d.getAltinmiktar() >= d.getHedefmaliyet()) {
                        d.setAltinmiktar(d.getAltinmiktar() - d.getHedefmaliyet());
                        System.out.println("D +20 Ekledi");
                        d.setHarcananaltin(d.getHarcananaltin() + d.getHedefmaliyet());
                        d.d_hedefbelirle(d, map, a, b, c);
                    }
                }

                d_aradakisatir = d.getD_hedefsatir() - d.getoyuncuSatir();
                d_aradakisutun = d.getD_hedefsutun() - d.getoyuncuSutun();
                d_hamlesayisi = d.getAdimsayisi();
                if (d.getAltinmiktar() < d.getHamlemaliyet()) {
                    d_hamlesayisi = 0;
                }
                d.setD_play(false);
            }
            if (d_hamlesayisi > 0 && temp == 3 && d.getAltinmiktar() >= 0) {
                if (d_hamlesayisi == d.getAdimsayisi()) {
                    System.out.println("D +5 Ekledi");
                    d.setAltinmiktar(d.getAltinmiktar() - d.getHamlemaliyet());
                    d.setHarcananaltin(d.getHarcananaltin() + d.getHamlemaliyet());
                }

                d_hamlesayisi--;
                if (d_aradakisutun < 0) {
                    solaKaydir(d);
                    d_aradakisutun++;
                } else if (d_aradakisutun > 0) {
                    sagaKaydir(d);
                    d_aradakisutun--;
                } else if (d_aradakisutun == 0 && d.getoyuncuSutun() == d.getD_hedefsutun()) {
                    timer.start();
                    if (d_aradakisatir < 0) {
                        yukariKaydir(d);
                        d_aradakisatir++;
                    } else if (d_aradakisatir > 0) {
                        asagiKaydir(d);
                        d_aradakisatir--;
                    }
                }
                if (d.getoyuncuSatir() == d.getD_hedefsatir() && d.getoyuncuSutun() == d.getD_hedefsutun()) {

                    if (map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] == 2) {
                        d.setAltinmiktar(d.getAltinmiktar() + 5);
                        d.setToplananaltin(d.getToplananaltin() + 5);
                        map.map[d.getD_hedefsatir()][d.getD_hedefsutun()] = 10;
                        altinsayi--;

                        if (d.getAltinmiktar() >= d.getHedefmaliyet()) {
                            d.setAltinmiktar(d.getAltinmiktar() - d.getHedefmaliyet());
                            System.out.println("D +20 Ekledi");
                            d.setHarcananaltin(d.getHarcananaltin() + d.getHedefmaliyet());
                            d.d_hedefbelirle(d, map, a, b, c);
                        }
                    }
                    if (map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] == 3) {
                        d.setAltinmiktar(d.getAltinmiktar() + 10);
                        d.setToplananaltin(d.getToplananaltin() + 10);
                        map.map[d.getD_hedefsatir()][d.getD_hedefsutun()] = 11;
                        altinsayi--;
                        if (d.getAltinmiktar() >= d.getHedefmaliyet()) {
                            d.setAltinmiktar(d.getAltinmiktar() - d.getHedefmaliyet());
                            System.out.println("D +20 Ekledi");
                            d.setHarcananaltin(d.getHarcananaltin() + d.getHedefmaliyet());
                            d.d_hedefbelirle(d, map, a, b, c);
                        }
                    }
                    if (map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] == 4) {
                        d.setAltinmiktar(d.getAltinmiktar() + 15);
                        d.setToplananaltin(d.getToplananaltin() + 15);
                        map.map[d.getD_hedefsatir()][d.getD_hedefsutun()] = 12;
                        altinsayi--;
                        if (d.getAltinmiktar() >= d.getHedefmaliyet()) {
                            d.setAltinmiktar(d.getAltinmiktar() - d.getHedefmaliyet());
                            System.out.println("D +20 Ekledi");
                            d.setHarcananaltin(d.getHarcananaltin() + d.getHedefmaliyet());
                            d.d_hedefbelirle(d, map, a, b, c);
                        }
                    }
                    if (map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] == 5) {
                        d.setAltinmiktar(d.getAltinmiktar() + 20);
                        d.setToplananaltin(d.getToplananaltin() + 20);
                        map.map[d.getD_hedefsatir()][d.getD_hedefsutun()] = 13;
                        altinsayi--;
                        if (d.getAltinmiktar() >= d.getHedefmaliyet()) {
                            d.setAltinmiktar(d.getAltinmiktar() - d.getHedefmaliyet());
                            System.out.println("D +20 Ekledi");
                            d.setHarcananaltin(d.getHarcananaltin() + d.getHedefmaliyet());
                            d.d_hedefbelirle(d, map, a, b, c);
                        }
                    }
                    d_hamlesayisi = 0;

                }
                if (map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] >= 6 && map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] <= 9) {
                    if (map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] == 6) {
                        map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] = 2;
                        altinsayi++;
                        gizlisayi--;

                    }
                    if (map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] == 7) {
                        map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] = 3;
                        altinsayi++;
                        gizlisayi--;
                    }
                    if (map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] == 8) {
                        map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] = 4;
                        altinsayi++;
                        gizlisayi--;
                    }
                    if (map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] == 9) {
                        map.map[d.getoyuncuSatir()][d.getoyuncuSutun()] = 5;
                        altinsayi++;
                        gizlisayi--;
                    }

                }
            } else if (d_hamlesayisi == 0 && temp == 3) {
                if (a.getAltinmiktar() > 0) {
                    a.setA_play(true);
                    temp = 0;
                } else if (b.getAltinmiktar() > 0) {
                    b.setB_play(true);
                    temp = 1;

                } else if (c.getAltinmiktar() > 0) {
                    c.setC_play(true);
                    temp = 2;

                } else if (d.getAltinmiktar() > 0) {
                    d.setD_play(true);
                    temp = 3;

                }
            }

            if (a.getAltinmiktar() < ak && b.getAltinmiktar() < bk && c.getAltinmiktar() < ck && d.getAltinmiktar() < dk) {
                System.out.println("Tüm oyuncuların altını bitti.");
                SKOR skor = new SKOR(a, b, c, d);
                skor.setBounds(250, 250, 750, 500);
                skor.setResizable(false);
                skor.setVisible(true);
                timer.stop();
            }

        } else {
            System.out.println("Oyun bitti.");
            SKOR skor = new SKOR(a, b, c, d);
            skor.setBounds(250, 250, 750, 500);
            skor.setResizable(false);
            skor.setVisible(true);
            timer.stop();
        }
    }
}
