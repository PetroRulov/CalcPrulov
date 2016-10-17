package app.control;

import app.model.Calculator;
import app.util.Service;
import app.view.panel.CalcPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 17.10.2016.
 */
public class PercentageControl implements ActionListener {

    private Calculator calculator;
    private Service serv;
    private CalcPanel cp;
    private String displayed;
    private String secondOperand;

    public PercentageControl(Calculator calculator, Service serv, CalcPanel cp){
        this.calculator = calculator;
        this.serv = serv;
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        displayed = cp.getWindowText();
        if (percentageApply(displayed)) {
            secondOperand = calculator.getSecondDouble(displayed);
            double res = calculator.calcPercentage(calculator.getSymbol(displayed), serv.lastResult(), secondOperand);
            String result = String.valueOf(res);
            cp.setDisplayedValue(result);
            serv.clearOperands();
            serv.addFirstOperandToList(result);
        } else {
            return;
        }
    }

    private boolean percentageApply(String str) {
        if(str.isEmpty() || str.equals(".") || serv.lastResult().equals("null") ||
                str.substring(str.length()-1, str.length()).equals(".")){
            return false;
//        } else if(str.substring(str.length()-2, str.length()).equals("--") ||
//                str.substring(str.length() - 2, str.length()).equals("/-")){
//            JOptionPane.showConfirmDialog(null, "ERROR: Redundant sign \"-\"! Please, use BACKSPACE or input VALUE and try again!",
//                    "Error message", JOptionPane.PLAIN_MESSAGE);
//            return false;
        } else if(noPercentValue(str)){
            JOptionPane.showConfirmDialog(null, "ERROR: Value missing! Please, use BACKSPACE or input VALUE and try again!",
                    "Error message", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean noPercentValue(String str){
        char signs[] = new char[]{'√', '%', '+', '*', '/', '-'};
        char strArr[] = str.substring(1, str.length()).toCharArray();
        for (char sign : signs) {
            if(strArr[strArr.length - 1] == sign){
                return true;
            }
        }
        return false;
    }
}
