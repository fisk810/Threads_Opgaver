package com.company;

import java.awt.image.BufferedImage;

public class ThreadPixel implements Runnable {
    int y;
    int x;
    BufferedImage img;

    public ThreadPixel(int y, int x, BufferedImage img) {
        this.y = y;
        this.x = x;
        this.img = img;
    }

    public void run(){
        int a = (int) (Math.random() * 256);
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);

        //pixel
        int p = (a << 24) | (r << 16) | (g << 8) | b;
        img.setRGB(x, y, p);
    }



}
