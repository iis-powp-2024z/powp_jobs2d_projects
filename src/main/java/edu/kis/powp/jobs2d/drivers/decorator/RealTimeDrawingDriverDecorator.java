package edu.kis.powp.jobs2d.drivers.decorator;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RealTimeDrawingDriverDecorator implements Job2dDriver {
    private final long delayBetweenStepsInMs;
    private final int pixelsDrawnInStep;
    private int x;
    private int y;
    private final Job2dDriver driver;
    private final ExecutorService executor;

    public RealTimeDrawingDriverDecorator(Job2dDriver driver, int unitsPerSecond, int pixelsDrawnInStep) {
        this.executor = Executors.newSingleThreadExecutor();
        this.driver = driver;

        this.pixelsDrawnInStep = pixelsDrawnInStep;
        long delay = Math.round(1000.0 / unitsPerSecond) * pixelsDrawnInStep;
        this.delayBetweenStepsInMs = Math.max(1, delay);

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

            double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            int steps = (int) distance / this.pixelsDrawnInStep;

            for (int step = 1; step <= steps; step++) {
                int intermediateX = this.x + (int) (deltaX * ((double) step / steps));
                int intermediateY = this.y + (int) (deltaY * ((double) step / steps));
                driver.operateTo(intermediateX, intermediateY);

                try {
                    Thread.sleep(this.delayBetweenStepsInMs);
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
