package edu.kis.powp.jobs2d.drivers.adapter.transformation;

import java.util.ArrayList;
import java.util.List;

public class TransformationsComposite implements TransformationMethod {
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

    @Override
    public TransformationPoint transform(TransformationPoint transformationPoint) {
        for (TransformationMethod transformationMethod : transformationMethods) {
            transformationPoint = transformationMethod.transform(transformationPoint);
        }

        return transformationPoint;
    }
}
