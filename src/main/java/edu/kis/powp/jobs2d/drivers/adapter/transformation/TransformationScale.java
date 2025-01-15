package edu.kis.powp.jobs2d.drivers.adapter.transformation;

public class TransformationScale implements TransformationMethod {

    private double scale;

    public TransformationScale(double scale) {
        this.scale = scale;
    }

    @Override
    public TransformationPoint transform(TransformationPoint transformationPoint) {
        transformationPoint.setX((int)(transformationPoint.getX() * this.scale));
        transformationPoint.setY((int)(transformationPoint.getY() * this.scale));

        return transformationPoint;
    }
}
