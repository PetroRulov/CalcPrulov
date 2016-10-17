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
public class OperationsControl implements ActionListener {

    private Calculator calculator;
    private Service serv;
    private CalcPanel cp;
    private JButton clicked;
    private String buttonText;
    private String displayed;
    private String firstOperand;

    public OperationsControl(Calculator calculator, Service serv, CalcPanel cp) {
        this.calculator = calculator;
        this.serv = serv;
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        displayed = cp.getWindowText();
        if (operationApply(displayed)) {
            clicked = (JButton) e.getSource();
            buttonText = cp.getClickedOperationButtonText(clicked);
            cp.setDisplayedValue(displayed + buttonText);
            cp.setWriterText(displayed + buttonText);
            displayed = cp.getWindowText();
            firstOperand = calculator.getFirstDouble(displayed);
            serv.addFirstOperandToList(firstOperand);
        }else {
            return;
        }
    }

    private boolean operationApply(String str) {
        if(str.isEmpty() || str.equals(".") ) return false;
        char signs[] = new char[]{'√', '%', '+', '-', '*', '/'};
        char strArr[] = str.substring(1, str.length()).toCharArray();
        int count = 0;
        for (int i = 0; i < strArr.length; i++) {
            for (char sign : signs) {
                if (strArr[i] == sign) {
                    count++;
                }
            }
        }
        if(count != 0){
            return false;
        }
        return true;
    }
}
