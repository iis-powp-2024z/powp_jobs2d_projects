package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RealTimeDrawingDriver implements Job2dDriver {
    private final int steps;
    private final int delay;
    private int x;
    private int y;
    private final Job2dDriver driver;
    private final ExecutorService executor;

    public RealTimeDrawingDriver(Job2dDriver driver, int steps, int delay) {
        this.steps = steps;
        this.delay = delay;
        this.x = 0;
        this.y = 0;
        this.driver = driver;
        this.executor = Executors.newSingleThreadExecutor();
    }

    @Override
    public void setPosition(int x, int y) {
        executor.submit(() -> executeDrawing(x, y, true));
    }

    @Override
    public void operateTo(int x, int y) {
        executor.submit(() -> executeDrawing(x, y, false));
    }

    private void executeDrawing(int targetX, int targetY, boolean isSetPosition) {
        int xStepSize = Math.abs(this.x - targetX) / steps;
        int yStepSize = Math.abs(this.y - targetY) / steps;

        for (int step = 0; step < steps; step++) {
            int newX = this.x + xStepSize * step;
            int newY = this.y + yStepSize * step;

            if (isSetPosition) {
                driver.setPosition(newX, newY);
            } else {
                driver.operateTo(newX, newY);
            }

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        if (isSetPosition) {
            driver.setPosition(targetX, targetY);
        } else {
            driver.operateTo(targetX, targetY);
        }

        this.x = targetX;
        this.y = targetY;
    }

    public void shutdown() {
        executor.shutdown();
    }
}
