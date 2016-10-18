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
public class MinusControl implements ActionListener {

    private Calculator calculator;
    private Service serv;
    private CalcPanel cp;
    private JButton clicked;
    private String buttonText;
    private String displayed;
    private String firstOperand;

    public MinusControl(Calculator calculator, Service serv, CalcPanel cp) {
        this.calculator = calculator;
        this.serv = serv;
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        displayed = cp.getWindowText();
        if (minusApply(displayed)) {
            clicked = (JButton) e.getSource();
            buttonText = clicked.getText();
            cp.setDisplayedValue(displayed + buttonText);
            cp.setWriterText(displayed + buttonText);

            if(!displayed.isEmpty()){
                displayed = cp.getWindowText();
                firstOperand = calculator.getFirstDouble(displayed);
                serv.addFirstOperandToList(firstOperand);
            }else {
                return;
            }
        }else {
            return;
        }
    }

    private boolean minusApply(String str) {
        if (str.isEmpty()){
            return true;
        } else {
            if (str.length() ==1 && str.equals(".") || str.length() ==1 && str.equals("-")) {
                return false;
            } else{
                if (hasMinus(str)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasMinus(String str) {
        char signMinus = '-';
        char strArr[] = str.substring(1, str.length()).toCharArray();
        int count = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == signMinus) {
                count++;
            }
        }
        if(count != 0){
            return true;
        }
        return false;
    }
}
