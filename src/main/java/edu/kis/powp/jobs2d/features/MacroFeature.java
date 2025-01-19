package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.builder.CompoundCommandBuilder;
import edu.kis.powp.jobs2d.events.SelectMacroOptionListener;

public class MacroFeature {
    private static Application application;
    private static CompoundCommandBuilder recordedCommand;

    private static boolean isRecording = false;

    public static void setupMacroFeature(Application app) {
        recordedCommand = new CompoundCommandBuilder();
        recordedCommand.setName("Record command");
        application = app;

        SelectMacroOptionListener clearOption = new SelectMacroOptionListener(0);
        SelectMacroOptionListener startOption = new SelectMacroOptionListener(1);

        application.addComponentMenu(MacroFeature.class, "Macro");
        application.addComponentMenuElement(MacroFeature.class, "Clear", clearOption);
        application.addComponentMenuElementWithCheckBox(MacroFeature.class, "Start/Stop", startOption, false);

    }
    public static void setCommand(DriverCommand command){
        if(isRecording){
            recordedCommand.addCommand(command);
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
        recordedCommand.clear();
    }

    public static CompoundCommand getRecordedCommand() {
        return recordedCommand.build();
    }
}