package app.view.panel;

import app.control.*;
import app.model.Calculator;
import app.util.Service;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.net.URL;
import java.util.*;

/**
 * Created by prulov on 16.10.2016.
 */
public class CalcPanel {

    private Calculator calculator;
    private Service serv;
    private JPanel calcPanel;
    private java.util.List<JButton> digitButtons;
    private java.util.List<JButton> symbolButtons;

    //buttons
    private JTextField window;
    private JButton bS;
    private JButton mM;
    private JButton mP;
    private JButton mC;
    private JButton mR;
    private JButton ceC;
    private JButton onAC;
    private JButton m1;
    private JButton m4;
    private JButton m7;
    private JButton m0;
    private JButton m2;
    private JButton m5;
    private JButton m8;
    private JButton m00;
    private JButton m3;
    private JButton m6;
    private JButton m9;
    private JButton point;
    private JButton sqrt;
    private JButton divid;
    private JButton plus;
    private JButton mult;
    private JButton mU;
    private JButton perc;
    private JButton minus;
    private JButton equal;

    public CalcPanel(Calculator calculator, Service serv){
        this.calculator = calculator;
        this.serv = serv;
        digitButtons = new ArrayList<>();
        symbolButtons = new ArrayList<>();
        this.calcPanel = createCalcPanel();
    }

    private JPanel createCalcPanel() {

        calcPanel = new JPanel();
        calcPanel.setLayout(new GridBagLayout());
        calcPanel.setBackground(Color.DARK_GRAY);
        calcPanel.setFont(new Font("Garamond", Font.BOLD, 20));

        Border matte = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLUE);
        Border titled = BorderFactory.createTitledBorder(matte, "CALCULATOR Model J-PEVLAR V.2.01, © Petro Rulov Laboratory", TitledBorder.CENTER,
                TitledBorder.CENTER, new Font("Garamond", Font.BOLD, 10), Color.ORANGE);
        calcPanel.setBorder(titled);

        URL imageURL = getClass().getClassLoader().getResource("calcaverage.png");
        ImageIcon icon = new ImageIcon(imageURL);
        JLabel picture = new JLabel(icon);
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.LEFT);
        calcPanel.add(picture, new GridBagConstraints(0, 0, 0, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(0, 10, 0, 0), 0, 0));

        window = new JTextField();
        window.setFont(new Font("Garamond", Font.BOLD, 36));
        window.setForeground(Color.BLUE);
        window.setHorizontalAlignment(JTextField.RIGHT);
        calcPanel.add(window, new GridBagConstraints(1, 0, 5, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));

        bS = new JButton("Backspace");
        bS.setFont(new Font("Garamond", Font.BOLD, 20));
        bS.setForeground(Color.BLACK);
        calcPanel.add(bS, new GridBagConstraints(0, 2, 2, 1, 50, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
        bS.addActionListener(new BackSpaceControl(calculator, serv, this));

        mM = new JButton("MS");
        mM.setFont(new Font("Garamond", Font.BOLD, 20));
        mM.setForeground(Color.BLACK);
        calcPanel.add(mM, new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));

        mP = new JButton("M+");
        mP.setFont(new Font("Garamond", Font.BOLD, 20));
        mP.setForeground(Color.BLACK);
        calcPanel.add(mP, new GridBagConstraints(3, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));

        mC = new JButton("MC");
        mC.setFont(new Font("Garamond", Font.BOLD, 20));
        mC.setForeground(Color.BLACK);
        calcPanel.add(mC, new GridBagConstraints(0, 3, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        mR = new JButton("0>>00");
        mR.setFont(new Font("Garamond", Font.BOLD, 20));
        mR.setForeground(Color.BLACK);
        calcPanel.add(mR, new GridBagConstraints(0, 4, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        ceC = new JButton("CE/C");
        ceC.setFont(new Font("Garamond", Font.BOLD, 20));
        ceC.setForeground(Color.BLACK);
        calcPanel.add(ceC, new GridBagConstraints(0, 5, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        onAC = new JButton("ON/AC");
        onAC.setFont(new Font("Garamond", Font.BOLD, 20));
        onAC.setForeground(Color.BLACK);
        onAC.setBackground(Color.ORANGE);
        calcPanel.add(onAC, new GridBagConstraints(0, 6, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 5), 0, 0));

        m1 = new JButton("1");
        m1.setFont(new Font("Garamond", Font.BOLD, 20));
        m1.setForeground(Color.BLACK);
        calcPanel.add(m1, new GridBagConstraints(1, 3, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
        m1.addActionListener(new DigitControl(this));

        m4 = new JButton("4");
        m4.setFont(new Font("Garamond", Font.BOLD, 20));
        m4.setForeground(Color.BLACK);
        calcPanel.add(m4, new GridBagConstraints(1, 4, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
        m4.addActionListener(new DigitControl(this));

        m7 = new JButton("7");
        m7.setFont(new Font("Garamond", Font.BOLD, 20));
        m7.setForeground(Color.BLACK);
        calcPanel.add(m7, new GridBagConstraints(1, 5, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
        m7.addActionListener(new DigitControl(this));

        m0 = new JButton("0");
        m0.setFont(new Font("Garamond", Font.BOLD, 20));
        m0.setForeground(Color.BLACK);
        calcPanel.add(m0, new GridBagConstraints(1, 6, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 5, 0, 10), 0, 0));
        m0.addActionListener(new DigitControl(this));

        m2 = new JButton("2");
        m2.setFont(new Font("Garamond", Font.BOLD, 20));
        m2.setForeground(Color.BLACK);
        calcPanel.add(m2, new GridBagConstraints(2, 3, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
        m2.addActionListener(new DigitControl(this));

        m5 = new JButton("5");
        m5.setFont(new Font("Garamond", Font.BOLD, 20));
        m5.setForeground(Color.BLACK);
        calcPanel.add(m5, new GridBagConstraints(2, 4, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
        m5.addActionListener(new DigitControl(this));

        m8 = new JButton("8");
        m8.setFont(new Font("Garamond", Font.BOLD, 20));
        m8.setForeground(Color.BLACK);
        calcPanel.add(m8, new GridBagConstraints(2, 5, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
        m8.addActionListener(new DigitControl(this));

        m00 = new JButton("00");
        m00.setFont(new Font("Garamond", Font.BOLD, 20));
        m00.setForeground(Color.BLACK);
        calcPanel.add(m00, new GridBagConstraints(2, 6, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
        m00.addActionListener(new DigitControl(this));

        m3 = new JButton("3");
        m3.setFont(new Font("Garamond", Font.BOLD, 20));
        m3.setForeground(Color.BLACK);
        calcPanel.add(m3, new GridBagConstraints(3, 3, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 15), 0, 0));
        m3.addActionListener(new DigitControl(this));

        m6 = new JButton("6");
        m6.setFont(new Font("Garamond", Font.BOLD, 20));
        m6.setForeground(Color.BLACK);
        calcPanel.add(m6, new GridBagConstraints(3, 4, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 15), 0, 0));
        m6.addActionListener(new DigitControl(this));

        m9 = new JButton("9");
        m9.setFont(new Font("Garamond", Font.BOLD, 20));
        m9.setForeground(Color.BLACK);
        calcPanel.add(m9, new GridBagConstraints(3, 5, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 15), 0, 0));
        m9.addActionListener(new DigitControl(this));

        point = new JButton(".");
        point.setFont(new Font("Garamond", Font.BOLD, 20));
        point.setForeground(Color.BLACK);
        calcPanel.add(point, new GridBagConstraints(3, 6, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 15), 0, 0));
        point.addActionListener(new PointControl(this));

        sqrt = new JButton("√");
        sqrt.setFont(new Font("Garamond", Font.BOLD, 20));
        sqrt.setForeground(Color.BLACK);
        calcPanel.add(sqrt, new GridBagConstraints(4, 2, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 5, 0, 10), 0, 0));
        sqrt.addActionListener(new OperationsControl(calculator, serv, this));

        divid = new JButton("/");
        divid.setFont(new Font("Garamond", Font.BOLD, 20));
        divid.setForeground(Color.BLACK);
        calcPanel.add(divid, new GridBagConstraints(4, 3, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
        divid.addActionListener(new OperationsControl(calculator, serv, this));

        plus = new JButton("+");
        plus.setFont(new Font("Garamond", Font.BOLD, 20));
        plus.setForeground(Color.BLACK);
        calcPanel.add(plus, new GridBagConstraints(4, 5, 1, 2, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
        plus.addActionListener(new OperationsControl(calculator, serv, this));

        mult = new JButton("*");
        mult.setFont(new Font("Garamond", Font.BOLD, 20));
        mult.setForeground(Color.BLACK);
        calcPanel.add(mult, new GridBagConstraints(4, 4, 1, 1, 1, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
        mult.addActionListener(new OperationsControl(calculator, serv, this));

        mU = new JButton("MU");
        mU.setFont(new Font("Garamond", Font.BOLD, 20));
        mU.setForeground(Color.BLACK);
        calcPanel.add(mU, new GridBagConstraints(5, 2, 1, 1, 1, 0, GridBagConstraints.LAST_LINE_END, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));

        perc = new JButton("%");
        perc.setFont(new Font("Garamond", Font.BOLD, 20));
        perc.setForeground(Color.BLACK);
        calcPanel.add(perc, new GridBagConstraints(5, 3, 1, 1, 1, 0, GridBagConstraints.LAST_LINE_END, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
        //perc.addActionListener(new OperationsControl(calculator, serv, this));
        perc.addActionListener(new PercentageControl(calculator, serv, this));

        minus = new JButton("-");
        minus.setFont(new Font("Garamond", Font.BOLD, 20));
        minus.setForeground(Color.BLACK);
        calcPanel.add(minus, new GridBagConstraints(5, 4, 1, 1, 1, 0, GridBagConstraints.LAST_LINE_END, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
        minus.addActionListener(new MinusControl(calculator, serv, this));

        equal = new JButton("=");
        equal.setFont(new Font("Garamond", Font.BOLD, 20));
        equal.setBackground(Color.cyan);
        equal.setForeground(Color.BLACK);
        equal.setEnabled(true);
        calcPanel.add(equal, new GridBagConstraints(5, 5, 1, 2, 1, 0, GridBagConstraints.LAST_LINE_END, GridBagConstraints.BOTH, new Insets(10, 10, 0, 10), 0, 0));
        equal.addActionListener(new EqualControl(calculator, serv, this));

        digitButtons.add(m1);
        digitButtons.add(m2);
        digitButtons.add(m3);
        digitButtons.add(m4);
        digitButtons.add(m5);
        digitButtons.add(m6);
        digitButtons.add(m7);
        digitButtons.add(m8);
        digitButtons.add(m9);
        digitButtons.add(m0);
        digitButtons.add(m00);

        symbolButtons.add(plus);
        symbolButtons.add(mult);
        symbolButtons.add(divid);
        symbolButtons.add(sqrt);
        //symbolButtons.add(perc);

        return calcPanel;
    }

    public JPanel getCalcPanel() {
        return calcPanel;
    }

    private JTextField getWindow() {
        return window;
    }

    public String getWindowText(){
        return getWindow().getText();
    }

    private JButton getClickedButton(JButton button){
        JButton clicked = null;
        for (JButton jButton : digitButtons) {
            if(jButton.equals(button)){
                clicked = jButton;
            }
        }
        return clicked;
    }

    public String getButtonText(JButton button){
        return getClickedButton(button).getText();
    }

    private JButton getPoint() {
        return point;
    }

    public String getPointText(){
        return getPoint().getText();
    }

    public void setDisplayedValue(String str) {
        window.setText(str);
    }

    private JButton getClickedOperationButton(JButton button){
        JButton clicked = null;
        for (JButton jButton : symbolButtons) {
            if(jButton.equals(button)){
                clicked = jButton;
            }
        }
        return clicked;
    }

    public String getClickedOperationButtonText(JButton button){
        return getClickedOperationButton(button).getText();
    }
}
