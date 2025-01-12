package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.Job2dDriver;

import javax.swing.*;
import java.util.List;

public class TransformationDriverAdapter implements Job2dDriver {
    private Job2dDriver driver;
    private List<TransformationMethod> transformationMethods;
    private int x = 0, y = 0;

    public TransformationDriverAdapter(Job2dDriver driver) {
        this.driver = driver;
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
        driver.operateTo(x + this.x, y + this.y);
        setPosition(x + this.x, y + this.y);
    }


}
