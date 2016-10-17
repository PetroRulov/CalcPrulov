package app.control;

import app.model.Calculator;
import app.util.Service;
import app.view.panel.CalcPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 16.10.2016.
 */
public class BackSpaceControl implements ActionListener {

    private Calculator calculator;
    private Service serv;
    private CalcPanel cp;
    private String displayed;

    public BackSpaceControl(Calculator calculator, Service serv, CalcPanel cp){
        this.calculator = calculator;
        this.serv = serv;
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        displayed = cp.getWindowText();
        cp.setDisplayedValue(displayed.substring(0, displayed.length() - 1));
        serv.clearOperands();
        checkDisplayed();
    }

    private void checkDisplayed() {
        System.out.println(cp.getWindowText());
        displayed = cp.getWindowText();
        if(cp.getWindowText().length() > 1){
            String str = calculator.getFirstDouble(displayed);
            serv.addFirstOperandToList(str);
        }

    }
}
