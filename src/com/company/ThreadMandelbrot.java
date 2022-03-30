package com.company;

import java.awt.image.BufferedImage;

public class ThreadMandelbrot implements Runnable {

    private final int MAX_ITER = 570;
    private final double ZOOM = 150;
    private double zx, zy, cX, cY, tmp;
    int maxHeight = 600;
    int maxWidth = 800;
    int minHeight = 0;
    int minWidth = 0;
    BufferedImage img;

    public ThreadMandelbrot(int maxHeight, int maxWidth, int minHeight, int minWidth, BufferedImage img) {
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
        this.minHeight = minHeight;
        this.minWidth = minWidth;
        this.img = img;
    }

    public void run() {
        for (int y = minHeight; y < maxHeight; y++) {
            for (int x = minWidth; x < maxWidth; x++) {
                zx = zy = 0;
                cX = (x - 400) / ZOOM;
                cY = (y - 300) / ZOOM;
                int iter = MAX_ITER;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }
                img.setRGB(x, y, iter | (iter << 8));
            }
        }
    }






}
