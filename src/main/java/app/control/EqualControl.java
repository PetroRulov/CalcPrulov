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
public class EqualControl implements ActionListener {

    private Calculator calculator;
    private Service serv;
    private CalcPanel cp;
    private String displayed;
    private String secondOperand;

    public EqualControl(Calculator calculator, Service serv, CalcPanel cp) {
        this.calculator = calculator;
        this.serv = serv;
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        displayed = cp.getWindowText();
        if (equalApply(displayed)) {
            if(!serv.lastResult().substring(0, 1).equals("-") || serv.lastResult().substring(0, 1).equals("-") &&
                    !calculator.getSymbol(displayed).equals("-")){                                // if first > 0 || if first < 0 and operant not "-"
                secondOperand = calculator.getSecondDouble(displayed);
            }else if(serv.lastResult().substring(0, 1).equals("-") && calculator.getSymbol(displayed).equals("-")) { // if first < 0 and oper is "-"
                if(calculator.getSymbol(displayed).equals("-")){
                    secondOperand = calculator.getSecondDoubleForFirstNegative(displayed);
                }
            }
            double res = calculator.calculate(calculator.getSymbol(displayed), serv.lastResult(), secondOperand);
            String result = String.valueOf(res);
            cp.setDisplayedValue(result);
            serv.clearOperands();
            serv.addFirstOperandToList(result);
        }else {
            return;
        }
    }

    private boolean equalApply(String str) {
        if(str.isEmpty() || str.equals(".") || serv.lastResult().equals("null")) return false;
        return true;
    }

}
