package com.ESC.rpn;

import com.ESC.rpn.entities.Base;
import com.ESC.rpn.entities.Decimal;
import com.ESC.rpn.entities.Operation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class RPNComp {
    Decimal decimal = new Decimal();
    List<String> operation = new ArrayList<>();
    List<String> lexem = new LinkedList<>();
    List<Operation> supportedOperations = new ArrayList<>();

//    public void parse(String expression) {
//
//        while (!expression.isEmpty()) {
//            String remainder = tryToParse(expression);
//            if (remainder.equals(expression)) {
//                remainder = tryToParse(expression);
//            }
//            expression = remainder;
//        }
//    }

    //TODO возникнут проблемы если цифра и функция начинается одинаково,
    //например cos(a) и шестнадцатеричные числа, начинающиеся с "c"
    //мб можно решить тем, что сначала ф=парсить функции, а потом числа

    //TODO неясно как парсить функции из больше чем одного символа

    //TODO реализовать унарные функции

    //TODO реализовать скобки

    //TODO тесты переписать, подумать какие случаи надо проверить
    public String tryToParseNumber(String expression) {
        String accumulator = "";
        int position = 0;
        if (expression.length()!=0) {
            if(expression.length()>position) {
                String firstSymbol = String.valueOf(expression.charAt(position));

                while (position < expression.length() - 1 && decimal.isNumber(firstSymbol)) {
                    accumulator += firstSymbol;
                    firstSymbol = String.valueOf(expression.charAt(++position));
                }

                if (!accumulator.isEmpty()) {
                    lexem.add(accumulator);
                }
            }
            expression = expression.substring(accumulator.length(), expression.length());
        }

        return expression;
    }

    public String tryToParseOperation(String expression) {
        String accumulator = "";
        int position = 0;
        String firstSymbol;

        while (position <= expression.length() - 1) {
            firstSymbol = String.valueOf(expression.charAt(position++));
            accumulator += firstSymbol;
        }

        if (!accumulator.isEmpty()) {
            operation.add(accumulator);
        }

        expression = expression.substring(accumulator.length(), expression.length());
        return expression;
    }

    public boolean isOperation(String symbol) {

        for (Operation operation : supportedOperations) {
            if (symbol.toString().equals(operation.getValue())) {
                return true;
            }
        }

        return false;
    }

//    public String count() {
//        String result = "Вычисление не выполнено";
//        int opSize = operation.size();
//        if (opSize != 0) {
//            for (int i = 0; i < opSize; i++) {
//                if (lexem.size() != 0) {
//                    if (lexem.size() >= 2) {
//                        String operation1 = operation.remove(0);
//
//                        //2 символа для выполнения бинарной операции
//                        int term1 = Integer.parseInt(lexem.remove(0));
//                        int term2 = Integer.parseInt(lexem.remove(0));
//
//                        for (Operation op : supportedOperations) {
//
//                            if (operation1.equals(op.getValue())) {
//
//                                lexem.add(0, String.valueOf(op.getCalculate().apply(term1, term2)));
//                                result = lexem.get(0);
//                            }
//                        }
//
//
//                    } else {
//                        result = "Недостаточно цифр для выполнения бинарной операции";
//                        System.out.println("Недостаточно цифр для выполнения бинарной операции");
//                    }
//
//                } else {
//                    result = "В строке не задано цифр";
//                    System.out.println("В строке не задано цифр");
//                }
//            }
//        } else {
//            result = "В строке не задано операций";
//            System.out.println("В строке не задано операций");
//        }
//
//        return result;
//    }


}

//}
