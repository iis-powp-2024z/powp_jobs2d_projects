package edu.kis.powp.jobs2d.features;
import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.builder.CompoundCommandBuilder;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.RecordMacroDriverDecorator;
import edu.kis.powp.jobs2d.drivers.observer.ApplyDriverDecoratorsSubscriber;
import edu.kis.powp.jobs2d.events.SelectMacroOptionListener;
import edu.kis.powp.jobs2d.events.SelectMacroOptionListener.MacroAction;

public class MacroFeature {
    private static Application application;
    private static CompoundCommandBuilder recordedCommand;
    private static final RecordMacroDriverDecorator recordMacroDriverDecorator = new RecordMacroDriverDecorator();

    private static boolean isRecording = false;

    public static void setupMacroFeature(Application app, DriverManager driverManager) {
        recordedCommand = new CompoundCommandBuilder();
        recordedCommand.setName("Record command");
        application = app;

        SelectMacroOptionListener clearOption = new SelectMacroOptionListener(MacroAction.CLEAR);
        SelectMacroOptionListener startOption = new SelectMacroOptionListener(MacroAction.TOGGLE);
        SelectMacroOptionListener runOption = new SelectMacroOptionListener(MacroAction.RUN);

        application.addComponentMenu(MacroFeature.class, "Macro");
        application.addComponentMenuElement(MacroFeature.class, "Clear", clearOption);
        application.addComponentMenuElementWithCheckBox(MacroFeature.class, "Start/Stop", startOption, false);
        application.addComponentMenuElement(MacroFeature.class, "Run", runOption);

        ApplyDriverDecoratorsSubscriber.getInstance().addDriverDecorator(recordMacroDriverDecorator);
        driverManager.addSubscriber(ApplyDriverDecoratorsSubscriber.getInstance());
    }
    public static void setCommand(DriverCommand command){
        if(isRecording){
            recordedCommand.addCommand(command);
        }
    }

    public static void toggle(){
        isRecording = !isRecording;
    }
    
    public static void run(){
        CompoundCommand command = getRecordedCommand();
        DriverCommandManager manager = CommandsFeature.getDriverCommandManager();
        manager.setCurrentCommand(command);
    }

    public static void clear(){
        recordedCommand.clear();
    }

    public static boolean isRecording() { return isRecording; }

    public static CompoundCommand getRecordedCommand() {
        return recordedCommand.build();
    }
}