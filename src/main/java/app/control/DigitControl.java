package app.control;

import app.view.panel.CalcPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 16.10.2016.
 */
public class DigitControl implements ActionListener {

    private CalcPanel cp;
    private JButton clicked;
    private String buttonText;
    private String displayed;

    public DigitControl(CalcPanel cp){
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        clicked = (JButton) e.getSource();
        buttonText = cp.getButtonText(clicked);
        displayed = cp.getWindowText();
        cp.setDisplayedValue(displayed + buttonText);
        cp.setWriterText(displayed + buttonText);
    }
}
