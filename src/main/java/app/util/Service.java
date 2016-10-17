package app.util;

import app.model.Calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 16.10.2016.
 */
public class Service {

    private Calculator calculator;
    private List<String> operands;
    private double lastResult;

    public Service(Calculator calculator){

        this.calculator = calculator;
        operands = new ArrayList<>();
        lastResult = 0.0;
    }

    public void addFirstOperandToList(String str){
        operands.add(str);
        lastResult = Double.parseDouble(operands.get(operands.size() - 1));
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
}
