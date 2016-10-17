package app.model;

/**
 * Created by prulov on 16.10.2016.
 */
public class Calculator {
    private String[] oper = new String[]{"+", "*", "/", "√", "%", "-"};

    public Calculator(){}

    public String getFirstDouble(String jtfDisplayed){
        //System.out.println(jtfDisplayed.substring(0, jtfDisplayed.length() - 1));
        String str = jtfDisplayed.substring(0, jtfDisplayed.length() - 1);
        for (String s : oper) {
            if(str.substring(str.length() - 1, str.length()).equals(s)){
                str = str.substring(0, str.length() - 1);
            }
        }
        System.out.println("firstDouble = " + str);
        return str;
        //return jtfDisplayed.substring(0, jtfDisplayed.length() - 1);
    }

    public String getSecondDouble(String jtfDisplayed){
        int a = getOperIndex(jtfDisplayed);
        if(a > 0){
            return jtfDisplayed.substring(a + 1, jtfDisplayed.length());
        }else{
            return "0.0";
        }
    }

    private int getOperIndex(String jtfDisplayed){
        int result = 0;
        for (int i = 0; i < oper.length; i++) {
            if(jtfDisplayed.substring(1, jtfDisplayed.length()).contains(oper[i])){
                result = jtfDisplayed.indexOf(oper[i]);
                break;
            }
        }
        return result;
    }

    public String getSecondDoubleForFirstNegative(String jtfDisplayed){
        int a = getLastMinusIndex(jtfDisplayed);
        return jtfDisplayed.substring(a + 1, jtfDisplayed.length());
    }

    private int getLastMinusIndex(String jtfDisplayed){
        int result = 0;
        char aux[] = jtfDisplayed.toCharArray();
        for (int i = aux.length - 1; i >= 0; i--) {
            if(aux[i]=='-' && aux[i-1]!='-'){
                result = i;
                break;
            }else if(aux[i]=='-' && aux[i-1]=='-'){
                result = i - 1;
                break;
            }
        }
        return result;
    }

    public String getSymbol(String jtfDisplayed){
        String result = "";
        for (int i = 0; i < oper.length; i++) {
            if(jtfDisplayed.substring(1, jtfDisplayed.length()).contains(oper[i])){
                result = oper[i];
                break;
            }
        }
        return result;
    }

    public double calculate(String str, String first, String second){
        double one = Double.parseDouble(first);
        double two = Double.parseDouble(second);
        double result = 0.0;
        if(str.equals("+")){
            result = one + two;
        }else if(str.equals("-")){
            result = one - two;
        }else{
            result = str.equals("*") ? one * two : one / two;
        }
        return result;
    }




    public double calcPercentage(String str, String first, String second){

        double result = 0.0;
        double one = Double.parseDouble(first);
        double two = Double.parseDouble(second);
        if(str.equals("+")){
            result = one + one / 100 * two;
        }else if(str.equals("-")){
            result = one - one / 100 * two;
        }else if(str.equals("*")){
            result = one / 100 * two;
        }else if(str.equals("/")){
            result = one / (one / 100 * two);
        }
        return result;
    }

}

