package app.control;

import app.model.Calculator;
import app.util.Service;
import app.view.panel.CalcPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 17.10.2016.
 */
public class MRecallControl implements ActionListener {

        private Calculator calculator;
        private Service serv;
        private CalcPanel cp;
        private String displayed;

        public MRecallControl(Calculator calculator, Service serv, CalcPanel cp) {
            this.calculator = calculator;
            this.serv = serv;
            this.cp = cp;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(serv.getMemoryNumber() == null) return;
            displayed = cp.getWindowText();
            cp.setDisplayedValue(displayed + serv.getMemoryNumber());
            cp.setWriterText(displayed + serv.getMemoryNumber());
        }

}
