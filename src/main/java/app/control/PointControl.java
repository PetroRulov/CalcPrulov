package app.control;

import app.view.panel.CalcPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 16.10.2016.
 */
public class PointControl implements ActionListener {

    private CalcPanel cp;
    private JButton clicked;
    private String buttonText;
    private String displayed;

    public PointControl(CalcPanel cp){
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        displayed = cp.getWindowText();
        if(pointApply(displayed)){
            buttonText = cp.getPointText();
            cp.setDisplayedValue(displayed + buttonText);
        }else {
            return;
        }
    }

    private boolean pointApply(String str) {
        if(str.isEmpty()) return true;
        if(containsTwoPoints(str)){
            return false;
        }

        char signs[] = new char[]{'√', '.', '%'};
        char strArr[] = str.toCharArray();
        for (char sign : signs) {
            if (strArr[str.length() - 1] == sign) {
                return false;
            } else {
                if (str.contains(".") && !containsSign(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean containsSign(String str){
        char signs[] = new char[]{'+', '-', '*', '/'};
        char strArr[] = str.substring(1, str.length()).toCharArray();
        for (char c : strArr) {
            for (char sign : signs) {
                if(c==sign){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean containsTwoPoints(String str){
        int count = 0;
        char strArr[] = str.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == '.') {
                count++;
            }
        }
        if(count > 1){
            return true;
        }
        return false;
    }

}
