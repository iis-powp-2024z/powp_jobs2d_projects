package edu.kis.powp.jobs2d.drivers.adapter.transformation;

import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;

public class TransformationDriver implements DriverDecorator {
    private final TransformationsComposite transformationsComposite = new TransformationsComposite();
    private VisitableJob2dDriver driver;
    private int x = 0, y = 0;

    @Override
    public void setPosition(int x, int y) {
        TransformationPoint transformationPoint = new TransformationPoint(x, y);
        transformationPoint = transformationsComposite.transform(transformationPoint);

        this.x = transformationPoint.getX();
        this.y = transformationPoint.getY();
        driver.setPosition(this.x, this.y);
    }

    @Override
    public void operateTo(int x, int y) {
        TransformationPoint transformationPoint = new TransformationPoint(x, y);
        transformationPoint = transformationsComposite.transform(transformationPoint);

        driver.operateTo(transformationPoint.getX(), transformationPoint.getY());
    }

    public void setDriver(VisitableJob2dDriver driver) {
        this.driver = driver;
    }

    public VisitableJob2dDriver getDriver() {
        return this.driver;
    }

    public void addTransformationMethod(TransformationMethod transformationMethod) {
        transformationsComposite.add(transformationMethod);
    }

    public void removeTransformationMethod(TransformationMethod transformationMethod) {
        transformationsComposite.remove(transformationMethod);
    }
}
