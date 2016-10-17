package app.util;

import app.model.Calculator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 16.10.2016.
 */
public class Service {

    private Calculator calculator;
    private List<String> operands;
    private double lastResult;
    private String memoryNumber;

    public Service(Calculator calculator){

        this.calculator = calculator;
        operands = new ArrayList<>();
        lastResult = 0.0;
        memoryNumber = null;
    }

    public void addFirstOperandToList(String str){
        operands.add(str);
        try{
            lastResult = Double.parseDouble(operands.get(operands.size() - 1));
        }catch (NumberFormatException nfe){
            JOptionPane.showConfirmDialog(null, "ERROR: Too much sign \"-\"! Please, use BACKSPACE and try again!",
                    "Error message", JOptionPane.PLAIN_MESSAGE);
            return;
        }
    }

    public void clearOperands() {
        operands.clear();
    }

    public double getLastResult() {
        return lastResult;
    }

    public String lastResult(){
        if(!operands.isEmpty()){
            return operands.get(operands.size() - 1);
        }else{
            return "null";
        }
    }

    public void setMemoryNumber(double d){
        memoryNumber = String.valueOf(d);
    }

    public void setMemoryNumberNull(){
        memoryNumber = null;
    }

    public String getMemoryNumber(){return memoryNumber;}

}
