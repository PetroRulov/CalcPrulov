package app.control;

import app.model.Calculator;
import app.util.Service;
import app.view.panel.CalcPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 17.10.2016.
 */
public class MSetControl implements ActionListener {

    private Calculator calculator;
    private Service serv;
    private CalcPanel cp;
    private String displayed;

    public MSetControl(Calculator calculator, Service serv, CalcPanel cp) {
        this.calculator = calculator;
        this.serv = serv;
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        displayed = cp.getWindowText();
        if(isDigit(displayed)){
            serv.setMemoryNumber(Double.parseDouble(displayed));
            cp.setMemory(serv.getMemoryNumber());
        }

    }

    private boolean isDigit(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
