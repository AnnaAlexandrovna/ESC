package com.ESC.rpn;

public class Main {

    public static void main(String[] args) {
	// write your code here


//        //тест 12
//        String s = "3123-12+";
//        com.ESC.rpn.Test1 test1 = new com.ESC.rpn.Test1();
//        test1.madeTwoArray(s);
//        System.out.println(test1.count());
//        for (int i = 0; i < test1.operation.size(); i++) {
//            System.out.println(test1.operation.get(i));
//        }
//        for (int i = 0; i < test1.leksem.size(); i++) {
//            System.out.println(test1.leksem.get(i));
//        }

//        //тест 11
        String s = "20+3";
        RPNComputer test1 = new RPNComputer();
        test1.madeTwoArray(s);
        System.out.println(test1.count());
        for (int i = 0; i < test1.operation.size(); i++) {
            System.out.println(test1.operation.get(i));
        }
        for (int i = 0; i < test1.leksem.size(); i++) {
            System.out.println(test1.leksem.get(i));
        }

        //тест 10
//        String s = "3123-12";
//        com.ESC.rpn.Test1 test1 = new com.ESC.rpn.Test1();
//        test1.madeTwoArray(s);
//        System.out.println(test1.count());
//        for (int i = 0; i < test1.operation.size(); i++) {
//            System.out.println(test1.operation.get(i));
//        }
//        for (int i = 0; i < test1.leksem.size(); i++) {
//            System.out.println(test1.leksem.get(i));
//        }


// тест 9
//        String s = "3123+12+";
//        com.ESC.rpn.Test1 test1 = new com.ESC.rpn.Test1();
//        test1.madeTwoArray(s);
//        System.out.println(test1.count());
//        for (int i = 0; i < test1.operation.size(); i++) {
//            System.out.println(test1.operation.get(i));
//        }
//        for (int i = 0; i < test1.leksem.size(); i++) {
//            System.out.println(test1.leksem.get(i));
//        }

        // тест 8
//        String s = "3123+12+14";
//        com.ESC.rpn.Test1 test1 = new com.ESC.rpn.Test1();
//        test1.madeTwoArray(s);
//        System.out.println(test1.count());
//        for (int i = 0; i < test1.operation.size(); i++) {
//            System.out.println(test1.operation.get(i));
//        }
//        for (int i = 0; i < test1.leksem.size(); i++) {
//            System.out.println(test1.leksem.get(i));
//        }



// тест 7
//        String s = "3123+12";
//        com.ESC.rpn.Test1 test1 = new com.ESC.rpn.Test1();
//        test1.madeTwoArray(s);
//        for (int i = 0; i < test1.operation.size(); i++) {
//            System.out.println(test1.operation.get(i));
//        }
//        for (int i = 0; i < test1.leksem.size(); i++) {
//            System.out.println(test1.leksem.get(i));
//        }

        //тест6
//        String s = "ё+-3123-+1";
//        com.ESC.rpn.Test1 test1 = new com.ESC.rpn.Test1();
//        test1.madeTwoArray(s);
//        for (int i = 0; i < test1.operation.size(); i++) {
//            System.out.println(test1.operation.get(i));
//        }
//        for (int i = 0; i < test1.leksem.size(); i++) {
//            System.out.println(test1.leksem.get(i));
//        }
//

        //тест5
//        String s = "+-3123-+1";
//        com.ESC.rpn.Test1 test1 = new com.ESC.rpn.Test1();
//        test1.madeTwoArray(s);
//        for (int i = 0; i < test1.operation.size(); i++) {
//            System.out.println(test1.operation.get(i));
//        }
//        for (int i = 0; i < test1.leksem.size(); i++) {
//            System.out.println(test1.leksem.get(i));
//        }
//

        //тест4, на то, что метод isOperation правильно работает
//        String s3 = "+-";
//        com.ESC.rpn.Test1 test3 = new com.ESC.rpn.Test1();
//        test3.isOperation(s3);
//        System.out.println(test3.operation.get(0));

         //тест3, на то, что метод isOperation правильно работает
//        String s3 = "+-+1";
//        com.ESC.rpn.Test1 test3 = new com.ESC.rpn.Test1();
//        System.out.println(test3.isOperation(s3));
//        System.out.println(test3.operation.get(0));


//        //тест2, на то, что метод isNumber правильно работает
//        String s2 = "1234";
//        com.ESC.rpn.Test1 test2 = new com.ESC.rpn.Test1();
//        test1.isNumber(s);
//        System.out.println(test1.leksem.get(0));
//
//        //тест1, на то, что метод isNumber правильно работает
//        String s1 = "12+34";
//        com.ESC.rpn.Test1 test1 = new com.ESC.rpn.Test1();
//        test1.isNumber(s);
//        System.out.println(test1.leksem.get(0));
    }
}
