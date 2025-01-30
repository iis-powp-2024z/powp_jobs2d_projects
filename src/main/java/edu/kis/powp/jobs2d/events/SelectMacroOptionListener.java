package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.features.MacroFeature;

public class SelectMacroOptionListener implements ActionListener {

    private final MacroAction action;

    public SelectMacroOptionListener(MacroAction action) {
        this.action = action;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (action) {
            case CLEAR:
                MacroFeature.clear();
                break;
            case TOGGLE:
                MacroFeature.toggle();
                break;
            case LOAD:
                MacroFeature.load();
                break;
        }
    }

    public enum MacroAction {
        CLEAR, TOGGLE, LOAD
    }
}