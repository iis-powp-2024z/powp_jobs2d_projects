package edu.kis.powp.jobs2d.drivers.decorator;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RealTimeDrawingDriverDecorator implements Job2dDriver {
    private final int steps;
    private final int delay;
    private int x;
    private int y;
    private final Job2dDriver driver;
    private final ExecutorService executor;

    public RealTimeDrawingDriverDecorator(Job2dDriver driver, int steps, int delay) {
        this.executor = Executors.newSingleThreadExecutor();
        this.driver = driver;

        this.steps = Math.max(1, steps);
        this.delay = Math.max(0, delay);

        this.x = 0;
        this.y = 0;
    }

    @Override
    public void setPosition(int x, int y) {
        executor.submit(() -> {
            this.driver.setPosition(x, y);
            this.x = x;
            this.y = y;
        });
    }

    @Override
    public void operateTo(int targetX, int targetY) {
        executor.submit(() -> {
            int deltaX = targetX - this.x;
            int deltaY = targetY - this.y;

            int xStepSize = deltaX / steps;
            int yStepSize = deltaY / steps;

            for (int step = 1; step <= steps; step++) {
                int newX = this.x + xStepSize * step;
                int newY = this.y + yStepSize * step;
                driver.operateTo(newX, newY);

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            driver.operateTo(targetX, targetY);
            this.x = targetX;
            this.y = targetY;
        });
    }

    @Override
    public String toString() {
        return driver.toString().concat(" - Real-time");
    }
}
