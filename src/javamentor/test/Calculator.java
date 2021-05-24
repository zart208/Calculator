package javamentor.test;

import javamentor.test.utils.RomanArabicConverter;
import javamentor.test.utils.TwoOperandsExpressionParser;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws WrongExpressionException {
        System.out.println("Калькулятор римских и арабских цифр");
        System.out.print("Введите вычисляемое выражение (два римских (I-X) или арабских числа (1-10) со знаком операции (+,-,*,/) между ними в одну строку, \nнапример: 1 + 1 или X - VI): ");
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
            throw new WrongExpressionException("Введенное выражение не соответствует условию задачи: оба числа должны быть одной системы - римской или арабской");
        }

        // конвертируем римские цифры в арабские
        if (!isArabicFirstOperand) {
            operand1 = RomanArabicConverter.romanOperandConvertToArabic(firstOperand);
            operand2 = RomanArabicConverter.romanOperandConvertToArabic(secondOperand);
        }

        if ((operand1 <= 0 || operand1 > 10) || (operand2 <= 0 || operand2 > 10)) {
            throw new WrongExpressionException("Введенное число не соответствует условию: диапазон вводимых значений (1-10) или (I-X)");
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
                throw new WrongExpressionException("Введенное выражение не соответстует условию задачи: неверный формат ввода");
            }
        }
        if (isArabicFirstOperand) {
            System.out.println(result);
        } else {
            System.out.println(RomanArabicConverter.arabicToRomanConvert(result));
        }
    }
}
