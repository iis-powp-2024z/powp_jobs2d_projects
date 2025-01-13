package edu.kis.powp.jobs2d.drivers.adapter.transformation;

import java.util.ArrayList;
import java.util.List;

public class TransformationComposite {

    private List<TransformationMethod> transformationMethods = new ArrayList<>();

    public List<TransformationMethod> getTransformationMethods() {
        return transformationMethods;
    }

    public void add(TransformationMethod transformationMethod) {
        this.transformationMethods.add(transformationMethod);
    }

    public void remove(TransformationMethod transformationMethod) {
        this.transformationMethods.remove(transformationMethod);
    }

    public TransformationPoint execute(TransformationPoint transformationPoint) {
        for (TransformationMethod method : transformationMethods) {
            transformationPoint.setX(method.transformX(transformationPoint.getX()));
            transformationPoint.setY(method.transformY(transformationPoint.getY()));
        }

        return transformationPoint;
    }

}
