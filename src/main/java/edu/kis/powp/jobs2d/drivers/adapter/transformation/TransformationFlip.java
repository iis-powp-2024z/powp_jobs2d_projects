package edu.kis.powp.jobs2d.drivers.adapter.transformation;

public class TransformationFlip implements TransformationMethod {

    private int xFlipMultiplier = 1;
    private int yFlipMultiplier = 1;

    public TransformationFlip(TransformationFlipAxis axis) {
        if (axis == TransformationFlipAxis.X) {
            this.yFlipMultiplier = -1;
        } else if (axis == TransformationFlipAxis.Y) {
            this.xFlipMultiplier = -1;
        }
    }

    @Override
    public int transformX(int x) {
        return x * this.xFlipMultiplier;
    }

    @Override
    public int transformY(int y) {
        return y * this.yFlipMultiplier;
    }
}
