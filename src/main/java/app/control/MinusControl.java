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
            if(!displayed.isEmpty()){
                clicked = (JButton) e.getSource();
                buttonText = clicked.getText();
                cp.setDisplayedValue(displayed + buttonText);
                displayed = cp.getWindowText();
                firstOperand = calculator.getFirstDouble(displayed);
                serv.addFirstOperandToList(firstOperand);
            }else {
                clicked = (JButton) e.getSource();
                buttonText = clicked.getText();
                cp.setDisplayedValue(displayed + buttonText);
            }
        }else {
            return;
        }

    }

    private boolean minusApply(String str) {
        if(str.equals(".") || str.equals("-") ) return false;
        char signMinus = '-';
        char strArr[] = str.toCharArray();
        int count = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == signMinus) {
                count++;
            }
        }
        if(count > 2){
            return false;
        }
        return true;
    }
}
