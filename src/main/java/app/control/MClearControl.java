package app.control;

import app.model.Calculator;
import app.util.Service;
import app.view.panel.CalcPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 17.10.2016.
 */
public class MClearControl implements ActionListener {

    private Calculator calculator;
    private Service serv;
    private CalcPanel cp;

    public MClearControl(Calculator calculator, Service serv, CalcPanel cp) {
        this.calculator = calculator;
        this.serv = serv;
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            serv.setMemoryNumberNull();
            cp.clearMemory();
    }

}
