package edu.kis.powp.jobs2d.command.visitor;

import edu.kis.powp.jobs2d.command.*;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationMethod;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationPoint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommandTransformationVisitor implements CommandVisitor {

    private final TransformationMethod transformationMethod;
    private DriverCommand visitedCommand;

    public CommandTransformationVisitor(TransformationMethod transformationMethod){
        this.transformationMethod = transformationMethod;
    }

    public DriverCommand getVisitedCommand() {
        return visitedCommand;
    }

    @Override
    public void visit(SetPositionCommand command) {
        TransformationPoint transformedPoint = transformPoint(command.getPosX(), command.getPosY());
        visitedCommand = new SetPositionCommand(transformedPoint.getX(), transformedPoint.getY());
    }

    @Override
    public void visit(OperateToCommand command) {
        TransformationPoint transformedPoint = transformPoint(command.getPosX(), command.getPosY());
        visitedCommand = new OperateToCommand(transformedPoint.getX(), transformedPoint.getY());
    }

    @Override
    public void visit(ICompoundCommand command) {
        Iterator<DriverCommand> iterator = command.iterator();
        List<DriverCommand> commandsList = new ArrayList<>();

        while (iterator.hasNext()) {
            DriverCommand driverCommand = iterator.next();
            driverCommand.accept(this);
            commandsList.add(visitedCommand);
        }

        visitedCommand = new CompoundCommand(commandsList, command.toString());
    }

    private TransformationPoint transformPoint(int x, int y) {
        TransformationPoint originalPoint = new TransformationPoint(x, y);
        return transformationMethod.transform(originalPoint);
    }
}