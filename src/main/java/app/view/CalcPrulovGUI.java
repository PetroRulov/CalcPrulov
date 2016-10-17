package app.view;

import app.model.Calculator;
import app.util.Service;
import app.view.panel.CalcPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 16.10.2016.
 */
public class CalcPrulovGUI {

    private Calculator calculator;
    private Service serv;

    private CalcPanel cp;
    private JFrame frame;
    private JPanel panel;
    private String head = "* J-PEVLAR V.2.01 *";

    public CalcPrulovGUI(Calculator calculator) {

        this.calculator = calculator;
        this.serv = new Service(calculator);
        this.cp = new CalcPanel(calculator, serv);

        this.frame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame(head);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(50, 50);
        frame.setMinimumSize(new Dimension(600, 425));

        frame.setJMenuBar(createMenuBar());

        panel = cp.getCalcPanel();
        frame.getContentPane().add(panel);


        frame.pack();
        frame.setVisible(true);
    }

    private JMenuBar createMenuBar(){
        Font bigFont = new Font("Verdana", Font.BOLD, 15);
        Font font = new Font("Verdana", Font.BOLD, 12);
        Font fant = new Font("Verdana", Font.BOLD, 9);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("FILE");
        fileMenu.setFont(bigFont);
        menuBar.add(fileMenu);

        //other menu items should be here

        JMenuItem exitItem = new JMenuItem("EXIT");
        exitItem.setFont(font);
        fileMenu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        return menuBar;
    }
}
