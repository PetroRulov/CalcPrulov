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
    private JButton clicked;

    public EqualControl(Calculator calculator, Service serv, CalcPanel cp) {
        this.calculator = calculator;
        this.serv = serv;
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        clicked = (JButton) e.getSource();
        displayed = cp.getWindowText();
        cp.setWriterText(displayed + clicked.getText());

        if (equalApply(displayed)) {
            if(!serv.lastResult().substring(0, 1).equals("-") || serv.lastResult().substring(0, 1).equals("-") &&
                    !calculator.getSymbol(displayed).equals("-")){                                // if first > 0 || if first < 0 and operant not "-"
                secondOperand = calculator.getSecondDouble(displayed);
            }else if(serv.lastResult().substring(0, 1).equals("-") && calculator.getSymbol(displayed).equals("-")) { // if first < 0 and oper is "-"
                //if(calculator.getSymbol(displayed).equals("-")){
                    secondOperand = calculator.getSecondDoubleForFirstNegative(displayed);
                //}
            }
            double res = calculator.calculate(calculator.getSymbol(displayed), serv.lastResult(), secondOperand);
            String result = String.valueOf(res);
            cp.setDisplayedValue(result);
            cp.setWriterText(displayed + clicked.getText() + result);
            serv.clearOperands();
            serv.addFirstOperandToList(result);
        }else {
            return;
        }
    }

    private boolean equalApply(String str) {
        if(str.isEmpty() || str.equals(".") || serv.lastResult().equals("null") ||
                str.substring(str.length()-1, str.length()).equals(".")){
            return false;
        } else if(str.substring(str.length()-2, str.length()).equals("--") ||
                str.substring(str.length()-2, str.length()).equals("/-")){
            return false;
        } else if(noSecondArgument(str) || noSymbols(str)){
            return false;
        }
        return true;
    }

    private boolean noSecondArgument(String str){
        char signs[] = new char[]{'√', '%', '+', '*', '/', '-'};
        char strArr[] = str.substring(1, str.length()).toCharArray();
        for (char sign : signs) {
            if(strArr[strArr.length - 1] == sign){
                return true;
            }
        }
        return false;
    }

    private boolean noSymbols(String str){
        char signs[] = new char[]{'√', '%', '+', '*', '/', '-'};
        char strArr[] = str.substring(1, str.length()).toCharArray();
        int count = 0;
        for (char sign : signs) {
            for (char ch : strArr) {
                if(ch==sign){
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
