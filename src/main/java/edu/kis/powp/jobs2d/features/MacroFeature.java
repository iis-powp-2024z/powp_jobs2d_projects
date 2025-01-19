package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.builder.CompoundCommandBuilder;
import edu.kis.powp.jobs2d.events.SelectMacroOptionListener;

import java.util.List;

public class MacroFeature {
    private static Application application;
    private static CompoundCommandBuilder recordCommand;

    private static boolean isRecording = false;

    public static void setupMacroFeature(Application app) {
        recordCommand = new CompoundCommandBuilder();
        recordCommand.setName("Record command");
        application = app;

        SelectMacroOptionListener clearOption = new SelectMacroOptionListener(0);
        SelectMacroOptionListener startOption = new SelectMacroOptionListener(1);

        application.addComponentMenu(MacroFeature.class, "Macro");
        application.addComponentMenuElement(MacroFeature.class, "Clear", clearOption);
        application.addComponentMenuElementWithCheckBox(MacroFeature.class, "Start/Stop", startOption, false);

    }
    public static void setCommand(DriverCommand command){
        if(isRecording){
            recordCommand.addCommand(command);
        }
    }

    public static void toggle(){
        isRecording = !isRecording;
        if (isRecording)
            System.out.println("start");
        else
            System.out.println("stop");
    }

    public static void clear(){
        System.out.println("clear");
        return;
    }

    public static CompoundCommand getRecordedCommand() {
        return recordCommand.build();
    }
}