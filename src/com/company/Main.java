package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;

public class Main {

    public static void main(String[] args) {
        int maxWidth = 640, maxHeight = 320;
        int maxBrotWidth =800, maxBrotHeight = 600;
        BufferedImage img = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage k = new BufferedImage(maxBrotWidth, maxBrotHeight, BufferedImage.TYPE_INT_RGB);
        CreateImage c1 = new CreateImage();

        c1.generatePixels();
        c1.generateImage();


/*
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                ThreadPixel tp = new ThreadPixel(i,j,img);
                Thread thread = new Thread(tp);
                thread.start();

            }
        }

        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                ThreadPixel tp = new ThreadPixel(i,j,img);
                Thread thread = new Thread(tp);
                thread.start();

            }
        }

        try
        {
            File f = new File("C:/Users/marcu/Dokumenter/PixelThreading/pop.png");
            ImageIO.write(img, "png", f);
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e);
        }
*/
        /*
        for (int i = 0; i < 600; i++) {
            for (int j = 0; j < 800; j++) {
                ThreadMandelbrot threadMandel = new ThreadMandelbrot(k);
                Thread t = new Thread(threadMandel);
                t.start();

            }
        }
        */
        ThreadMandelbrot mbt = new ThreadMandelbrot(600/2,0, 800/2,0,k);
        ThreadMandelbrot mbt2 = new ThreadMandelbrot(600,600/2,800/2,0,k);
        ThreadMandelbrot mbt3 = new ThreadMandelbrot(600/2,0,800,800/2,k);
        ThreadMandelbrot mbt4= new ThreadMandelbrot(600,600/2,800,800/2,k);

        Thread th1 = new Thread(mbt);
        Thread th2 = new Thread(mbt2);
        Thread th3 = new Thread(mbt3);
        Thread th4 = new Thread(mbt4);
        th1.start();
        th2.start();
        th3.start();
        th4.start();

        try
        {
            File g = new File("C:/Users/marcu/Dokumenter/PixelThreading/fel.png");
            ImageIO.write(k, "png", g);
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e);
        }

    }
}
