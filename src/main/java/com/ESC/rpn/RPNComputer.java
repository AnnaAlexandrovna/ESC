package com.ESC.rpn;

import com.ESC.rpn.entities.Operation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class RPNComputer {

    List<String> operation = new ArrayList<>();
    List<String> lexem = new LinkedList<>();
    List<Operation> supportedOperations = new ArrayList<>();

    public RPNComputer() {
        supportedOperations.add(new Operation("+", false, (Integer a, Integer b) -> a + b));
        supportedOperations.add(new Operation("-", false, (Integer a, Integer b) -> a - b));
        supportedOperations.add(new Operation("*", false, (Integer a, Integer b) -> a * b));
        supportedOperations.add(new Operation("/", false, (Integer a, Integer b) -> a / b));
    }

    public void parse(String expression, int base) {

        while (!expression.isEmpty()) {
            String remainder = tryToParse(expression, base, lexem, RPNComputer::isNumber);
            if (remainder.equals(expression)) {
                remainder = tryToParse(expression, base, operation, RPNComputer::isOperation);
            }
            expression = remainder;
        }
    }

    public String tryToParse(String expression, int base, List<String> arr, Function<Character, Boolean> whatTypeCharacterIs) {
        String accumulator = "";
        int position = 0;
        Character firstSymbol;

        while (position <= expression.length() - 1 && whatTypeCharacterIs.apply(firstSymbol = expression.charAt(position++))) {
            accumulator += firstSymbol;
        }

        if (!accumulator.isEmpty()) {
            arr.add(accumulator);
        }

        expression = expression.substring(accumulator.length(), expression.length());
        return expression;
    }


    public static boolean isOperation(Character symbol) {

        return Character.getType(symbol) == Character.MATH_SYMBOL || symbol == '-' || symbol == '*' || symbol == '-';

    }

    public static boolean isNumber(Character symbol) {

        return Character.getType(symbol) == Character.DECIMAL_DIGIT_NUMBER;

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

                        if (operation1.equals("+")) {

                            int res = term1 + term2;
                            result = res + "";
                            lexem.add(0, result);
                        }

                        if (operation1.equals("-")) {

                            int res = term1 - term2;
                            result = res + "";
                            lexem.add(0, result);
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
