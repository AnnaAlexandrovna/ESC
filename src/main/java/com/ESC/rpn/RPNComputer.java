package com.ESC.rpn;

import com.ESC.rpn.entities.*;

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
        //TODO поддержать зависимость операций от СС
        //интерфейс операция
        //две реализации
        supportedOperations.add(new Operation("+", false, (Integer a, Integer b) -> a + b));
        supportedOperations.add(new Operation("-", false, (Integer a, Integer b) -> a - b));
        supportedOperations.add(new Operation("*", false, (Integer a, Integer b) -> a * b));
        supportedOperations.add(new Operation("/", false, (Integer a, Integer b) -> a / b));


        //TODO поддержать другие СС
        supportedBases.add(new Decimal());
        supportedBases.add(new Binary());
        supportedBases.add(new Hexadecimal());
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

    //TODO возникнут проблемы если цифра и функция начинается одинаково,
    //например cos(a) и шестнадцатеричные числа, начинающиеся с "c"
    //мб можно решить тем, что сначала ф=парсить функции, а потом числа

    //TODO неясно как парсить функции из больше чем одного символа

    //TODO реализовать унарные функции

    //TODO реализовать скобки

    //TODO тесты переписать, подумать какие случаи надо проверить
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

    //count не должен быть паблик
    //сделать приватным, вызывать из parse, передавать основание СС
    public String count(int base) {
        // <удолить>
        Base baseEntity = null;
        for (Base b : supportedBases) {
            if (b.getBase() == base) {
                baseEntity = b;
            }
        }
        //</удолить>

        //разделить получение результата и обработку ошибок
        //сейчас одна переменная выполняет две роли
        //как исправить:
        //для бомжей - возвращать строку. Либо все хорошо и мы вернем строку с результатом, либо вернем сообщение об ошибке
        //для нормальных пацанов - возвращать структуру {результат, флаг успешно, сообщение об ошибке}

        String result = "Вычисление не выполнено";
        int opSize = operation.size();
        if (opSize != 0) {
            for (int i = 0; i < opSize; i++) {
                if (lexem.size() != 0) {
                    if (lexem.size() >= 2) {
                        String operation1 = operation.remove(0);

                        //2 символа для выполнения бинарной операции
                        //наверное стоит класть в лексемы числа в десятичном формате
                        //и убрать отсюда  baseEntity.toDecimal
                        //можно будет везде после самого парсинга хранить числа как инт, а не как стринг
                        int term1 = baseEntity.toDecimal(lexem.remove(0));
                        int term2 = baseEntity.toDecimal(lexem.remove(0));

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
        return baseEntity.fromDecimal(Integer.parseInt(result));
    }


}
