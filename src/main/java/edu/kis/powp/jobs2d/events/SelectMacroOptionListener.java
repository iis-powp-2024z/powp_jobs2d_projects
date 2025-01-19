package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.features.MacroFeature;

public class SelectMacroOptionListener implements ActionListener {

    private final int option;

    public SelectMacroOptionListener(int option) {
        this.option = option;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (option){
            case 0: MacroFeature.clear(); break;
            case 1: MacroFeature.toggle(); break;
        }
    }
}