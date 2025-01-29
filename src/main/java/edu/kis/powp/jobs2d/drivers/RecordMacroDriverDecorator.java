package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.features.MacroFeature;
import edu.kis.powp.jobs2d.command.OperateToCommand;

    public class RecordMacroDriverDecorator implements DriverDecorator {
    private Job2dDriver driver;
    @Override
    public void setPosition(int x, int y) {
        driver.setPosition(x, y);
        if (MacroFeature.isRecording())
            MacroFeature.setCommand(new SetPositionCommand(x,y));
    }

    @Override
    public void operateTo(int x, int y) {
        driver.operateTo(x, y);
        if (MacroFeature.isRecording())
            MacroFeature.setCommand(new OperateToCommand(x,y));
    }

    @Override
    public String toString() {
        return "Macro driver";
    }

    @Override
    public Job2dDriver getDriver() {
        return driver;
    }

    @Override
    public void setDriver(Job2dDriver driver) {
        this.driver = driver;
    }
}