package edu.kis.powp.jobs2d.drivers.adapter.transformation;

public class TransformationScale implements TransformationMethod {

    private double scale;

    public TransformationScale(double scale) {
        this.scale = scale;
    }

    @Override
    public int transformX(int x) {
        return (int) (x * this.scale);
    }

    @Override
    public int transformY(int y) {
        return (int) (y * this.scale);
    }
}
