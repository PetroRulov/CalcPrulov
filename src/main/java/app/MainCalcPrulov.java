package app;

import app.model.Calculator;
import app.view.CalcPrulovGUI;

/**
 * Created by prulov on 16.10.2016.
 */
public class MainCalcPrulov {

    public static void main(String[] args) {

        new CalcPrulovGUI(new Calculator());
    }
}
