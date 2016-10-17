package app.control;

import app.util.Service;
import app.view.panel.CalcPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 17.10.2016.
 */
public class CEControl implements ActionListener {

    private Service serv;
    private CalcPanel cp;

    public CEControl(Service serv, CalcPanel cp){
        this.serv = serv; this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cp.setDisplayedValue("");
        serv.clearOperands();
    }
}
