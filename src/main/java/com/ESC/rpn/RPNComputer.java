package com.ESC.rpn;

import com.ESC.rpn.entities.Base;
import com.ESC.rpn.entities.Decimal;
import com.ESC.rpn.entities.Operation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class RPNComputer {

    List<String> operation = new ArrayList<>();
    List<String> lexem = new LinkedList<>();
    List<Operation> supportedOperations = new ArrayList<>();
    List<Base> supportedBases = new ArrayList<>();

    public RPNComputer() {
        supportedOperations.add(new Operation("+", false, (Integer a, Integer b) -> a + b));
        supportedOperations.add(new Operation("-", false, (Integer a, Integer b) -> a - b));
        supportedOperations.add(new Operation("*", false, (Integer a, Integer b) -> a * b));
        supportedOperations.add(new Operation("/", false, (Integer a, Integer b) -> a / b));

        supportedBases.add(new Decimal());
    }

    public void parse(String expression, int base) {
        Base baseEntity = null;
        for (Base b : supportedBases) {
            if (b.getBase() == base) {
                baseEntity = b;
            }
        }

        while (!expression.isEmpty()) {
            String remainder = tryToParse(expression, base, lexem, baseEntity::isNumber);
            if (remainder.equals(expression)) {
                remainder = tryToParse(expression, base, operation, this::isOperation);
            }
            expression = remainder;
        }
    }

    public String tryToParse(String expression, int base, List<String> arr, Function<String, Boolean> whatTypeCharacterIs) {
        String accumulator = "";
        int position = 0;
        String firstSymbol;

        while (position <= expression.length() - 1 && whatTypeCharacterIs.apply(firstSymbol = String.valueOf(expression.charAt(position++)))) {
            accumulator += firstSymbol;
        }

        if (!accumulator.isEmpty()) {
            arr.add(accumulator);
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

    public String count() {
        String result = "Вычисление не выполнено";
        int opSize = operation.size();
        if (opSize != 0) {
            for (int i = 0; i < opSize; i++) {
                if (lexem.size() != 0) {
                    if (lexem.size() >= 2) {
                        String operation1 = operation.remove(0);
                        //2 символа для выполнения бинарной операции
                        int term1 = Integer.parseInt(lexem.remove(0));
                        int term2 = Integer.parseInt(lexem.remove(0));

                        for (Operation op : supportedOperations) {

                            if (operation1.equals(op.getValue())) {

                                lexem.add(0, String.valueOf(op.getCalculate().apply(term1, term2)));
                                result = lexem.get(0);
                            }
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
