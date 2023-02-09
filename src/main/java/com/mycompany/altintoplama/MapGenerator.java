/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.altintoplama;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author DELL
 */
public class MapGenerator {


    public int getGizlisayisi() {
        return gizlisayisi;
    }

    public void setGizlisayisi(int gizlisayisi) {
        this.gizlisayisi = gizlisayisi;
    }

    public int getAltinsayisi() {
        return altinsayisi;
    }

    public void setAltinsayisi(int altinsayisi) {
        this.altinsayisi = altinsayisi;
    }
    
    public int getToplamaltin() {
        return toplamaltin;
    }

    public void setToplamaltin(int toplamaltin) {
        this.toplamaltin = toplamaltin;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }
    
    public int map[][];
    public int width;
    public int height;
    public Oyuncu oyuncular [];
    public int toplamaltin;
    public int gizlisayisi;
    public int altinsayisi;
    
    public MapGenerator(int row, int col, int toplam_altin, int gizlialtin, Oyuncu [] oyunculiste) {
        oyuncular = oyunculiste;
        int deger1, deger2, deger3, sayac = 0, temp2;
        int toplamkare = row * col;
        
        toplamaltin = (toplamkare * toplam_altin) / 100;
        gizlisayisi = (toplamaltin * gizlialtin) / 100;
        altinsayisi = toplamaltin - gizlisayisi;
        
        ArrayList<Integer> Satir = new ArrayList<Integer>();
        ArrayList<Integer> Sutun = new ArrayList<Integer>();
        ArrayList<Integer> degerler = new ArrayList<Integer>();
        
        
        Random rand = new Random();


        for (int i = 0; i < toplamaltin ; i++) {
            temp2 = 0;
            sayac++;
            deger1 = rand.nextInt(row);
            deger2 = rand.nextInt(col);
            
            if ((deger1 == 0 && deger2 == 0) || (deger1 == row - 1 && deger2 == 0) || (deger1 == 0 && deger2 == col - 1) || (deger1 == row - 1 && deger2 == col - 1)) {
                i--;
                continue;
            }
            if (Satir.size() == 0) {
                Satir.add(deger1);
                Sutun.add(deger2);
                continue;
            }
            for (int j = 0; j < Satir.size(); j++) {

                if (Satir.get(j) == deger1 && Sutun.get(j) == deger2) {
                    i--;
                    temp2 = 1;
                    break;
                }
            }
            if (temp2 == 0) {
                Satir.add(deger1);
                Sutun.add(deger2);
            }
        }
        
        for (int i = 0 ; i < toplamaltin ; i++ ){
            deger3 = rand.nextInt(4);
            deger3++;
            degerler.add(deger3*5);
        }
        
        map = new int[row][col];
        int temp = 0;
        width = 1280 / col;
        height = 790 / row;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = 1;

            }
        }
        for (int i = gizlisayisi; i < toplamaltin; i++) {
            if (degerler.get(i) == 5)
                map[Satir.get(i)][Sutun.get(i)] = 2;
            else if (degerler.get(i) == 10)
                map[Satir.get(i)][Sutun.get(i)] = 3;
            else if (degerler.get(i) == 15)
                map[Satir.get(i)][Sutun.get(i)] = 4;
            else if (degerler.get(i) == 20)    
                map[Satir.get(i)][Sutun.get(i)] = 5;

        }
        for (int i = 0 ; i < gizlisayisi ; i++){
            if (degerler.get(i) == 5)
                map[Satir.get(i)][Sutun.get(i)] = 6;
            else if (degerler.get(i) == 10)
                map[Satir.get(i)][Sutun.get(i)] = 7;
            else if (degerler.get(i) == 15)
                map[Satir.get(i)][Sutun.get(i)] = 8;
            else if (degerler.get(i) == 20)    
                map[Satir.get(i)][Sutun.get(i)] = 9;
        }
        

    }

    public void draw(Graphics2D g) {
        
        Oyuncu a =oyuncular[0];
        Oyuncu b =oyuncular[1];
        Oyuncu c =oyuncular[2];
        Oyuncu d =oyuncular[3];
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    g.setColor(Color.lightGray);
                    g.fillRect(j * width, i * height, width, height);

                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * width, i * height, width, height);
                    
                }
                if (map[i][j] == 2) {
                    g.setColor(Color.yellow);
                    g.fillRect(j * width, i * height, width, height);

                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * width, i * height, width, height);
                    g.drawString("5", j * width+7, i * height + height-7);
                    
                }
                if (map[i][j] == 3) {
                    g.setColor(Color.yellow);
                    g.fillRect(j * width, i * height, width, height);

                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * width, i * height, width, height);
                    g.drawString("10", j * width+7, i * height + height-7);
                }
                if (map[i][j] == 4) {
                    g.setColor(Color.yellow);
                    g.fillRect(j * width, i * height, width, height);

                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * width, i * height, width, height);
                    g.drawString("15", j * width+7, i * height + height-7);
                }
                if (map[i][j] == 5) {
                    g.setColor(Color.yellow);
                    g.fillRect(j * width, i * height, width, height);

                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * width, i * height, width, height);
                    g.drawString("20", j * width+7, i * height + height-7);
                }
                if (map[i][j] == 6) {
                    g.setColor(Color.RED);
                    g.fillRect(j * width, i * height, width, height);

                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * width, i * height, width, height);
                    g.drawString("5", j * width+7, i * height + height-7);
                }
                if (map[i][j] == 7) {
                    g.setColor(Color.RED);
                    g.fillRect(j * width, i * height, width, height);

                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * width, i * height, width, height);
                    g.drawString("10", j * width+7, i * height + height-7);
                }
                if (map[i][j] == 8) {
                    g.setColor(Color.RED);
                    g.fillRect(j * width, i * height, width, height);

                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * width, i * height, width, height);
                    g.drawString("15", j * width+7, i * height + height-7);
                }
                if (map[i][j] == 9) {
                    g.setColor(Color.RED);
                    g.fillRect(j * width, i * height, width, height);

                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * width, i * height, width, height);
                    g.drawString("20", j * width+7, i * height + height-7);
                    
                }
                if (map[i][j] == 10) {
                    g.setColor(Color.green);
                    g.fillRect(j * width, i * height, width, height);

                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * width, i * height, width, height);
                    g.drawString("5", j * width+7, i * height + height-7);
                    
                }
                if (map[i][j] == 11) {
                    g.setColor(Color.green);
                    g.fillRect(j * width, i * height, width, height);

                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * width, i * height, width, height);
                    g.drawString("10", j * width+7, i * height + height-7);
                    
                }
                if (map[i][j] == 12) {
                    g.setColor(Color.green);
                    g.fillRect(j * width, i * height, width, height);

                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * width, i * height, width, height);
                    g.drawString("15", j * width+7, i * height + height-7);
                    
                }
                if (map[i][j] == 13) {
                    g.setColor(Color.green);
                    g.fillRect(j * width, i * height, width, height);

                    g.setStroke(new BasicStroke(1));
                    g.setColor(Color.black);
                    g.drawRect(j * width, i * height, width, height);
                    g.drawString("20", j * width+7, i * height + height-7);
                    
                }
                
            }
        }
    }
    
}
