package com.ESC.rpn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList( 1, 2, 3, 4, 5);

//        for (Integer even : filter(nums, (Integer a) -> (a*a) > 4)) {
////            System.out.println(even);
////        }

        //задание на субботу после того как ты проснешься:
        //1. сделать так чтобы можно было просто посчитать сумму квадратов(кубов и т.д.) всех четных(нечетных и т.д.) элементов массива
        //1* сделать это меняя и не меняя функцию аггрегейт =)
        System.out.println(aggregate(nums,0,(Integer a, Integer b) -> (a+b*b)));

    }

    static List<Integer> filter(List<Integer> args, Function<Integer, Boolean> nuzhno) {
        //возвращает список всех элементов, удовлетворяющих функции, переданной в параметрах
        List<Integer> arrayList = new ArrayList();

        for (int i = 0; i < args.size(); i++) {
            if (nuzhno.apply(args.get(i))) {
                arrayList.add(args.get(i));
            }
        }
        return arrayList;
    }

    //функция которая принимает список интов и считает сумму всех элементов
    static int aggregate (List<Integer> args, int neutral, BiFunction<Integer, Integer, Integer> operation){

        for (int arg : args) {
            neutral=operation.apply(neutral, arg);
        }
        return neutral;
    }
    //функция которая принимает список интов и считает произведение всех элементов
    static int product (List<Integer> args){
        int product = 1;
        for (int arg : args) {
            product*=arg;
        }
        return product;
    }
}
