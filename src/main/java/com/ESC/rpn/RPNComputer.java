package com.ESC.rpn;

import java.util.ArrayList;
import java.util.LinkedList;

public class RPNComputer {

    ArrayList operation = new ArrayList();
    LinkedList leksem = new LinkedList ();
    String stringOfNumber = "";
    String stringOfOperation = "";
    String allSimbol = "";


    public String isNumber(String string) {
        String firstSymbol = "";
        allSimbol = string;
        if (allSimbol.length() != 0) {
            firstSymbol = allSimbol.substring(0, 1);

            if (firstSymbol.equals("1") || firstSymbol.equals("0") || firstSymbol.equals("2") || firstSymbol.equals("3") ||
                    firstSymbol.equals("4") || firstSymbol.equals("5")
                    || firstSymbol.equals("6") || firstSymbol.equals("7") || firstSymbol.equals("8") || firstSymbol.equals("9")) {

                stringOfNumber = stringOfNumber + firstSymbol;

                allSimbol = allSimbol.substring(1, allSimbol.length());
                if (allSimbol.length() != 0) {
                    firstSymbol = allSimbol.substring(0, 1);
                    isNumber(allSimbol);
                }
            }

            if (stringOfNumber.length() != 0) {
                leksem.add(stringOfNumber);
            }
            stringOfNumber = "";
        }
        return allSimbol;
    }

    public String isOperation(String string) {
        String firstSymbol = "";

        allSimbol = string;
        if (allSimbol.length() != 0) {

            firstSymbol = allSimbol.substring(0, 1);

            if (firstSymbol.equals("+") || firstSymbol.equals("-")) {

                stringOfOperation = stringOfOperation + firstSymbol;

                allSimbol = allSimbol.substring(1, allSimbol.length());
                if (allSimbol.length() != 0) {
                    firstSymbol = allSimbol.substring(0, 1);

                    isOperation(allSimbol);
                }
            }

            if (stringOfOperation.length() != 0) {
                operation.add(stringOfOperation);
            }
            stringOfOperation = "";
            firstSymbol = "";
        }
        return allSimbol;
    }

    public void madeTwoArray(String string) {
        if (string.length() != 0) {
            string = isNumber(string);
            string = isOperation(string);
            int len1 = string.length();
            string = isNumber(string);
            int len2 = string.length();
            if (len1 !=0 && len1 == len2) {
                System.out.println("Извините, строка: " + string + " некорректна");
                string = "";
            }
            madeTwoArray(string);
        }
    }

    public String count (){
        String result = "Вычисление не выполнено";
        int opSize = operation.size();
        if (opSize!=0){
            for (int i = 0; i < opSize; i++) {
                if (leksem.size() != 0) {
                    if (leksem.size() >= 2) {
                        String operation1 = (String) operation.get(0);
                        operation.remove(0);
                        //2 символа для выполнения бинарной операции
                        int term1 = Integer.parseInt((String) leksem.get(0));
                        leksem.remove(0);
                        int term2 = Integer.parseInt((String) leksem.get(0));
                        leksem.remove(0);

                        if (operation1.equals("+")) {

                            int res = term1 + term2;
                            result = res + "";
                            leksem.add(0, result);
                        }
                        if (operation1.equals("-")) {

                            int res = term1 - term2;
                            result = res + "";
                            leksem.add(0, result);
                        }
                    } else {
                        result = "Недостаточно цифр для выполнения бинарной операции";
                        System.out.println("Недостаточно цифр для выполнения бинарной операции");
                    }

                } else {
                    result = "В строке не задано цифр";
                    System.out.println("В строке не задано цифр");
                }
            }
        } else {
            result = "В строке не задано операций";
            System.out.println("В строке не задано операций");
        }

        return result;
    }


}
