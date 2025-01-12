package edu.kis.powp.jobs2d.drivers.adapter.transformation;

public class TransformationScale2TimesUp implements TransformationMethod {
    @Override
    public int transformX(int x) {
        return x * 2;
    }

    @Override
    public int transformY(int y) {
        return y * 2;
    }
}
