package edu.kis.powp.jobs2d.drivers.adapter.transformation;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class TransformationDriver implements Job2dDriver {
    private final List<TransformationMethod> transformationMethods = new ArrayList<>();
    private Job2dDriver driver;
    private int x = 0, y = 0;

    public TransformationDriver() {
    }

    @Override
    public void setPosition(int x, int y) {
        for (TransformationMethod transformation : transformationMethods) {
            x = transformation.transformX(x);
            y = transformation.transformY(y);
        }

        this.x = x;
        this.y = y;
        driver.setPosition(x, y);
    }

    @Override
    public void operateTo(int x, int y) {
        for (TransformationMethod transformation : transformationMethods) {
            x = transformation.transformX(x);
            y = transformation.transformY(y);
        }

        driver.operateTo(x, y);
    }

    public void setDriver(Job2dDriver driver) {
        this.driver = driver;
    }

    public void addTransformationMethod(TransformationMethod transformationMethod) {
        transformationMethods.add(transformationMethod);
    }

    public void removeTransformationMethod(TransformationMethod transformationMethod) {
        transformationMethods.remove(transformationMethod);
    }
}
