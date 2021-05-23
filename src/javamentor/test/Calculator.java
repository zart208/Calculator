package javamentor.test;

import javamentor.test.utils.RomanArabicConverter;
import javamentor.test.utils.TwoOperandsExpressionParser;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Калькулятор римских и арабских цифр");
        System.out.print("Введите вычисляемое выражение (два римских (I-X) или арабских числа (1-10) со знаком операции между ними в одну строку, например: 1 + 1 ): ");
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();

        // парсим выражение
        TwoOperandsExpressionParser parser = new TwoOperandsExpressionParser(expression);
        String firstOperand = parser.getFirstOperand();
        String secondOperand = parser.getSecondOperand();
        String operator = parser.getOperator();

        // проверяем, чтобы оба числа были одного типа
        int operand1 = 0, operand2 = 0;
        boolean isArabicFirstOperand = true;
        boolean isArabicSecondOperand = true;
        try {
            operand1 = Integer.parseInt(firstOperand);
        } catch (NumberFormatException e) {
            isArabicFirstOperand = false;
        }
        try {
            operand2 = Integer.parseInt(secondOperand);
        } catch (NumberFormatException e) {
            isArabicSecondOperand = false;
        }
        if (isArabicFirstOperand ^ isArabicSecondOperand) {
            System.out.println("Не верный ввод!!!");
            return;
        }

        // конвертируем римские цифры в арабские
        if (!isArabicFirstOperand) {
            operand1 = RomanArabicConverter.romanOperandConvertToArabic(firstOperand);
            operand2 = RomanArabicConverter.romanOperandConvertToArabic(secondOperand);
        }


        // выполняем операцию
        int result = 0;
        switch (operator) {
            case "+": {
                result = operand1 + operand2;
                break;
            }
            case "-": {
                result = operand1 - operand2;
                break;
            }
            case "*": {
                result = operand1 * operand2;
                break;
            }
            case "/": {
                result = operand1 / operand2;
                break;
            }
            default: {
                System.out.println("Не верный ввод!!!");
                return;
            }
        }
//        if (isArabicFirstOperand) {
//            System.out.println(result);
//        } else {
            System.out.println(RomanArabicConverter.arabicResultConvertToRoman(126));
//        }

//            System.out.println(operand1);
//            System.out.println(operand2);
//            System.out.println(operator);


    }
}
