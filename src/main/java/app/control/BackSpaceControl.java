package app.control;

import app.view.panel.CalcPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 16.10.2016.
 */
public class BackSpaceControl implements ActionListener {

    private CalcPanel cp;
    private String displayed;

    public BackSpaceControl(CalcPanel cp){
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        displayed = cp.getWindowText();
        cp.setDisplayedValue(displayed.substring(0, displayed.length() - 1));
    }
}
