package com.mycompany.altintoplama;

import static java.lang.Math.*;
import java.util.ArrayList;

public class Oyuncu {

    public int id;
    public int altinmiktar;
    public int baslangicaltin;
    public int index;
    public int adimsayisi;
    public int hamlemaliyet;
    public int hedefmaliyet;
    public int oyuncusatir;
    public int oyuncusutun;
    public int a_hedefsatir;
    public int a_hedefsutun;
    public int b_hedefsatir;
    public int b_hedefsutun;
    public int c_hedefsatir;
    public int c_hedefsutun;
    public int d_hedefsatir;
    public int d_hedefsutun;
    public int toplananaltin = 0;
    public int harcananaltin = 0;
    public int atilanadim = 0;
    public boolean a_play = true;
    public boolean b_play = false;
    public boolean c_play = false;
    public boolean d_play = false;
    public int mesafe;

    public MapGenerator map;

    public Oyuncu(int altinmiktar, int adimsayisi, int hamlemaliyet, int hedefmaliyet, int oyuncusatir, int oyuncusutun, int a_hedefsatir, int a_hedefsutun, int b_hedefsatir, int b_hedefsutun, int c_hedefsatir, int c_hedefsutun, int d_hedefsatir, int d_hedefsutun, MapGenerator map) {
        this.altinmiktar = altinmiktar;
        this.adimsayisi = adimsayisi;
        this.hamlemaliyet = hamlemaliyet;
        this.hedefmaliyet = hedefmaliyet;
        this.oyuncusatir = oyuncusatir;
        this.oyuncusutun = oyuncusutun;
        this.a_hedefsatir = a_hedefsatir;
        this.a_hedefsutun = a_hedefsutun;
        this.b_hedefsatir = b_hedefsatir;
        this.b_hedefsutun = b_hedefsutun;
        this.c_hedefsatir = c_hedefsatir;
        this.c_hedefsutun = c_hedefsutun;
        this.d_hedefsatir = d_hedefsatir;
        this.d_hedefsutun = d_hedefsutun;
        this.map = map;
    }

    public int getAtilanadim() {
        return atilanadim;
    }

    public void setAtilanadim(int atilanadim) {
        this.atilanadim = atilanadim;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Oyuncu() {

    }

    public int getBaslangicaltin() {
        return baslangicaltin;
    }

    public void setBaslangicaltin(int baslangicaltin) {
        this.baslangicaltin = baslangicaltin;
    }

    public int getMesafe() {
        return mesafe;
    }

    public void setMesafe(int mesafe) {
        this.mesafe = mesafe;
    }

    public int getHarcananaltin() {
        return harcananaltin;
    }

    public void setHarcananaltin(int harcananaltin) {
        this.harcananaltin = harcananaltin;
    }

    public boolean isA_play() {
        return a_play;
    }

    public void setA_play(boolean a_play) {
        this.a_play = a_play;
    }

    public boolean isB_play() {
        return b_play;
    }

    public void setB_play(boolean b_play) {
        this.b_play = b_play;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isC_play() {
        return c_play;
    }

    public void setC_play(boolean c_play) {
        this.c_play = c_play;
    }

    public boolean isD_play() {
        return d_play;
    }

    public void setD_play(boolean d_play) {
        this.d_play = d_play;
    }

    public int getA_hedefsatir() {
        return a_hedefsatir;
    }

    public void setA_hedefsatir(int a_hedefsatir) {
        this.a_hedefsatir = a_hedefsatir;
    }

    public int getA_hedefsutun() {
        return a_hedefsutun;
    }

    public void setA_hedefsutun(int a_hedefsutun) {
        this.a_hedefsutun = a_hedefsutun;
    }

    public int getB_hedefsatir() {
        return b_hedefsatir;
    }

    public void setB_hedefsatir(int b_hedefsatir) {
        this.b_hedefsatir = b_hedefsatir;
    }

    public int getB_hedefsutun() {
        return b_hedefsutun;
    }

    public void setB_hedefsutun(int b_hedefsutun) {
        this.b_hedefsutun = b_hedefsutun;
    }

    public int getC_hedefsatir() {
        return c_hedefsatir;
    }

    public void setC_hedefsatir(int c_hedefsatir) {
        this.c_hedefsatir = c_hedefsatir;
    }

    public int getC_hedefsutun() {
        return c_hedefsutun;
    }

    public void setC_hedefsutun(int c_hedefsutun) {
        this.c_hedefsutun = c_hedefsutun;
    }

    public int getD_hedefsatir() {
        return d_hedefsatir;
    }

    public void setD_hedefsatir(int d_hedefsatir) {
        this.d_hedefsatir = d_hedefsatir;
    }

    public int getD_hedefsutun() {
        return d_hedefsutun;
    }

    public void setD_hedefsutun(int d_hedefsutun) {
        this.d_hedefsutun = d_hedefsutun;
    }

    public int getoyuncuSatir() {
        return oyuncusatir;
    }

    public void setoyuncuSatir(int satir) {
        this.oyuncusatir = satir;
    }

    public int getoyuncuSutun() {
        return oyuncusutun;
    }

    public void setoyuncuSutun(int sutun) {
        this.oyuncusutun = sutun;
    }

    public int getAltinmiktar() {
        return altinmiktar;
    }

    public void setAltinmiktar(int altinmiktar) {
        this.altinmiktar = altinmiktar;
    }

    public int getAdimsayisi() {
        return adimsayisi;
    }

    public void setAdimsayisi(int adimsayisi) {
        this.adimsayisi = adimsayisi;
    }

    public int getHamlemaliyet() {
        return hamlemaliyet;
    }

    public void setHamlemaliyet(int hamlemaliyet) {
        this.hamlemaliyet = hamlemaliyet;
    }

    public int getHedefmaliyet() {
        return hedefmaliyet;
    }

    public void setHedefmaliyet(int hedefmaliyet) {
        this.hedefmaliyet = hedefmaliyet;
    }

    public int getToplananaltin() {
        return toplananaltin;
    }

    public void setToplananaltin(int toplananaltin) {
        this.toplananaltin = toplananaltin;
    }

    public void a_hedefbelirle(Oyuncu oyuncu, MapGenerator map) {

        int i;
        int enyakin = 1000;
        ArrayList<Integer> Satir = new ArrayList<Integer>();
        ArrayList<Integer> Sutun = new ArrayList<Integer>();
        for (i = 0; i < map.map.length; i++) {
            for (int j = 0; j < map.map[0].length; j++) {
                if (map.map[i][j] < 6 && map.map[i][j] > 1) {
                    Satir.add(i);
                    Sutun.add(j);
                }
            }
        }
        for (int j = 0; j < Satir.size(); j++) {
            oyuncu.setMesafe(Math.abs(oyuncu.getoyuncuSatir() - Satir.get(j)) + Math.abs(oyuncu.getoyuncuSutun() - Sutun.get(j)));
            if (enyakin > oyuncu.getMesafe()) {
                enyakin = oyuncu.getMesafe();

                oyuncu.setIndex(j);
                oyuncu.setA_hedefsatir(Satir.get(j));
                oyuncu.setA_hedefsutun(Sutun.get(j));
            }

        }
        oyuncu.setMesafe(enyakin);

    }

    public void b_hedefbelirle(Oyuncu oyuncu, MapGenerator map) {
        int i, enkarli = -5000, karli;

        ArrayList<Integer> Satir = new ArrayList<Integer>();
        ArrayList<Integer> Sutun = new ArrayList<Integer>();
        ArrayList<Integer> Degerler = new ArrayList<Integer>();
        for (i = 0; i < map.map.length; i++) {
            for (int j = 0; j < map.map[0].length; j++) {
                if (map.map[i][j] < 6 && map.map[i][j] > 1) {
                    Satir.add(i);
                    Sutun.add(j);
                }
            }
        }
        for (i = 0; i < Satir.size(); i++) {
            if (map.map[Satir.get(i)][Sutun.get(i)] == 2) {
                Degerler.add(5);
            }
            if (map.map[Satir.get(i)][Sutun.get(i)] == 3) {
                Degerler.add(10);
            }
            if (map.map[Satir.get(i)][Sutun.get(i)] == 4) {
                Degerler.add(15);
            }
            if (map.map[Satir.get(i)][Sutun.get(i)] == 5) {
                Degerler.add(20);
            }

        }
        int yakinmesafe = 0;
        for (int j = 0; j < Satir.size(); j++) {
            oyuncu.setMesafe(Math.abs(oyuncu.getoyuncuSatir() - Satir.get(j)) + Math.abs(oyuncu.getoyuncuSutun() - Sutun.get(j)));
            karli = Degerler.get(j) - (int) Math.ceil((double) mesafe / oyuncu.getAdimsayisi()) * oyuncu.getHamlemaliyet();

            if (enkarli < karli) {
                yakinmesafe = oyuncu.getMesafe();
                enkarli = karli;
                oyuncu.setIndex(j);
                oyuncu.setB_hedefsatir(Satir.get(j));
                oyuncu.setB_hedefsutun(Sutun.get(j));

            }
        }
        oyuncu.setMesafe(yakinmesafe);

    }

    public int c_hedefbelirle(Oyuncu oyuncu, MapGenerator map, int gizlisayi) {
        int i;
        int enkarli = -5000, karli;
        float enyakin = 1000;
        ArrayList<Integer> Satir = new ArrayList<Integer>();
        ArrayList<Integer> Sutun = new ArrayList<Integer>();
        ArrayList<Integer> Degerler = new ArrayList<Integer>();
        ArrayList<Integer> Gsatir = new ArrayList<Integer>();
        ArrayList<Integer> Gsutun = new ArrayList<Integer>();
        for (i = 0; i < map.map.length; i++) {
            for (int j = 0; j < map.map[0].length; j++) {

                if (map.map[i][j] < 10 && map.map[i][j] > 5) {
                    Gsatir.add(i);
                    Gsutun.add(j);
                }
            }

        }
        int tempj = 0, t = 2;
        if (gizlisayi != 0) {
            if (gizlisayi == 1) {
                t = 1;
            }
            for (i = 0; i < t; i++) {
                for (int j = 0; j < Gsatir.size(); j++) {
                    int gizlimesafe = Math.abs(oyuncu.getoyuncuSatir() - Gsatir.get(j)) + Math.abs(oyuncu.getoyuncuSutun() - Gsutun.get(j));
                    if (enyakin > gizlimesafe) {
                        enyakin = gizlimesafe;
                        tempj = j;

                    }

                }

                if (map.map[Gsatir.get(tempj)][Gsutun.get(tempj)] == 6) {
                    map.map[Gsatir.get(tempj)][Gsutun.get(tempj)] = 2;
                }
                if (map.map[Gsatir.get(tempj)][Gsutun.get(tempj)] == 7) {
                    map.map[Gsatir.get(tempj)][Gsutun.get(tempj)] = 3;
                }
                if (map.map[Gsatir.get(tempj)][Gsutun.get(tempj)] == 8) {
                    map.map[Gsatir.get(tempj)][Gsutun.get(tempj)] = 4;
                }
                if (map.map[Gsatir.get(tempj)][Gsutun.get(tempj)] == 9) {
                    map.map[Gsatir.get(tempj)][Gsutun.get(tempj)] = 5;
                }
                Gsatir.remove(tempj);
                Gsutun.remove(tempj);
                gizlisayi--;
                enyakin = 1000;

            }
        }

        for (i = 0; i < map.map.length; i++) {
            for (int j = 0; j < map.map[0].length; j++) {
                if (map.map[i][j] < 6 && map.map[i][j] > 1) {
                    Satir.add(i);
                    Sutun.add(j);
                }

            }

        }

        for (i = 0; i < Satir.size(); i++) {
            if (map.map[Satir.get(i)][Sutun.get(i)] == 2) {
                Degerler.add(5);
            }
            if (map.map[Satir.get(i)][Sutun.get(i)] == 3) {
                Degerler.add(10);
            }
            if (map.map[Satir.get(i)][Sutun.get(i)] == 4) {
                Degerler.add(15);
            }
            if (map.map[Satir.get(i)][Sutun.get(i)] == 5) {
                Degerler.add(20);
            }

        }
        int yakinmesafe = 0;
        for (int j = 0; j < Satir.size(); j++) {
            oyuncu.setMesafe(Math.abs(oyuncu.getoyuncuSatir() - Satir.get(j)) + Math.abs(oyuncu.getoyuncuSutun() - Sutun.get(j)));
            karli = Degerler.get(j) - (int) Math.ceil((double) oyuncu.getMesafe() / oyuncu.getAdimsayisi()) * oyuncu.getHamlemaliyet();

            if (enkarli < karli) {
                yakinmesafe = oyuncu.getMesafe();
                enkarli = karli;
                oyuncu.setIndex(j);
                oyuncu.setC_hedefsatir(Satir.get(j));
                oyuncu.setC_hedefsutun(Sutun.get(j));

            }
        }
        oyuncu.setMesafe(yakinmesafe);
        return gizlisayi;
    }

    public void d_hedefbelirle(Oyuncu oyuncu, MapGenerator map, Oyuncu a, Oyuncu b, Oyuncu c) {
        int i, enkarli = -5000, karli;

        ArrayList<Integer> Satir = new ArrayList<Integer>();
        ArrayList<Integer> Sutun = new ArrayList<Integer>();
        ArrayList<Integer> Degerler = new ArrayList<Integer>();

        for (i = 0; i < map.map.length; i++) {
            for (int j = 0; j < map.map[0].length; j++) {
                if (map.map[i][j] < 6 && map.map[i][j] > 1) {
                    Satir.add(i);
                    Sutun.add(j);
                }
            }
        }
        int ahedefuzaklik, bhedefuzaklik, chedefuzaklik, dninahedefuzaklik, dninbhedefuzaklik, dninchedefuzaklik;
        dninahedefuzaklik = Math.abs(oyuncu.getoyuncuSatir() - a.getA_hedefsatir()) + Math.abs(oyuncu.getoyuncuSutun() - a.getA_hedefsutun());
        dninbhedefuzaklik = Math.abs(oyuncu.getoyuncuSatir() - b.getB_hedefsatir()) + Math.abs(oyuncu.getoyuncuSutun() - b.getB_hedefsutun());
        dninchedefuzaklik = Math.abs(oyuncu.getoyuncuSatir() - c.getC_hedefsatir()) + Math.abs(oyuncu.getoyuncuSutun() - c.getC_hedefsutun());
        dninahedefuzaklik = (int) Math.ceil(dninahedefuzaklik / oyuncu.getAdimsayisi());
        dninbhedefuzaklik = (int) Math.ceil(dninbhedefuzaklik / oyuncu.getAdimsayisi());
        dninchedefuzaklik = (int) Math.ceil(dninchedefuzaklik / oyuncu.getAdimsayisi());
        ahedefuzaklik = Math.abs(a.getoyuncuSatir() - a.getA_hedefsatir()) + Math.abs(a.getoyuncuSutun() - a.getA_hedefsutun());
        bhedefuzaklik = Math.abs(b.getoyuncuSatir() - b.getB_hedefsatir()) + Math.abs(b.getoyuncuSutun() - b.getB_hedefsutun());
        chedefuzaklik = Math.abs(c.getoyuncuSatir() - c.getC_hedefsatir()) + Math.abs(c.getoyuncuSutun() - c.getC_hedefsutun());
        ahedefuzaklik = (int) Math.ceil(ahedefuzaklik / oyuncu.getAdimsayisi());
        bhedefuzaklik = (int) Math.ceil(ahedefuzaklik / oyuncu.getAdimsayisi());
        chedefuzaklik = (int) Math.ceil(ahedefuzaklik / oyuncu.getAdimsayisi());

        if (dninahedefuzaklik > ahedefuzaklik) {
            for (i = 0; i < Satir.size(); i++) {
                if (Satir.get(i) == a.getA_hedefsatir() && Sutun.get(i) == a.getA_hedefsutun()) {
                    Satir.remove(i);
                    Sutun.remove(i);
                }
            }
        }

        if (dninbhedefuzaklik > bhedefuzaklik) {
            for (i = 0; i < Satir.size(); i++) {
                if (Satir.get(i) == b.getB_hedefsatir() && Sutun.get(i) == b.getB_hedefsutun()) {
                    Satir.remove(i);
                    Sutun.remove(i);
                }
            }

        }
        if (dninchedefuzaklik > chedefuzaklik) {
            for (i = 0; i < Satir.size(); i++) {
                if (Satir.get(i) == c.getC_hedefsatir() && Sutun.get(i) == c.getC_hedefsutun()) {
                    Satir.remove(i);
                    Sutun.remove(i);
                }
            }

        }

        for (i = 0; i < Satir.size(); i++) {
            if (map.map[Satir.get(i)][Sutun.get(i)] == 2) {
                Degerler.add(5);
            }
            if (map.map[Satir.get(i)][Sutun.get(i)] == 3) {
                Degerler.add(10);
            }
            if (map.map[Satir.get(i)][Sutun.get(i)] == 4) {
                Degerler.add(15);
            }
            if (map.map[Satir.get(i)][Sutun.get(i)] == 5) {
                Degerler.add(20);
            }

        }

        for (int j = 0; j < Satir.size(); j++) {
            oyuncu.setMesafe(Math.abs(oyuncu.getoyuncuSatir() - Satir.get(j)) + Math.abs(oyuncu.getoyuncuSutun() - Sutun.get(j)));
            karli = Degerler.get(j) - (int) Math.ceil((double) oyuncu.getMesafe() / oyuncu.getAdimsayisi()) * oyuncu.getHamlemaliyet();

            if (enkarli < karli) {

                enkarli = karli;

                oyuncu.setD_hedefsatir(Satir.get(j));
                oyuncu.setD_hedefsutun(Sutun.get(j));

            }
        }

    }

}
