package edu.kis.powp.jobs2d.drivers;

import java.awt.Rectangle;

import edu.kis.powp.jobs2d.Job2dDriver;

public class BoundsExtractorDriver implements Job2dDriver {
    private int minX = Integer.MAX_VALUE;
    private int minY = Integer.MAX_VALUE;
    private int maxX = Integer.MIN_VALUE;
    private int maxY = Integer.MIN_VALUE;

    @Override
    public void setPosition(int x, int y) {
       setBounds(x, y);
    }

    @Override
    public void operateTo(int x, int y) {
       setBounds(x, y);
    }

    @Override
    public String toString() {
        return "Bounds extractor driver";
    }

    private void setBounds(int x, int y){
        if (x < minX) {
            minX = x;
        }
        if (x > maxX) {
            maxX = x;
        }
        if (y < minY) {
            minY = y;
        }
        if (y > maxY) {
            maxY = y;
        }
    }

    public void clearBounds(){
        minX = Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        maxY = Integer.MIN_VALUE;
    }

    public Rectangle getBounds(){
        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }
}