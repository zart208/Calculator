package javamentor.test;

import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Калькулятор римских и арабских цифр");
        input:
        while (true) {
            System.out.print("Введите вычисляемое выражение (два римских (I-X) или арабских числа (1-10) со знаком операции между ними в одну строку, например: 1 + 1 ) или \"0\" для выхода: ");
            Scanner input = new Scanner(System.in);
            String expression = input.nextLine();
            if (expression.equals("0")) {
                break;
            }

            // парсим выражение
            String firstOperand = "", secondOperand = "", operator = "";
            for (int i = 0; i <= (expression.length() - 1); i++) {
                if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'
                        || expression.charAt(i) == '/') {
                    operator += expression.charAt(i);
                    for (int j = i + 1; j <= (expression.length() - 1); j++) {
                        secondOperand += expression.charAt(j);
                    }
                    break;
                } else {
                    firstOperand += expression.charAt(i);
                }
            }
            firstOperand = firstOperand.trim();
            secondOperand = secondOperand.trim();

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
                continue;
            }

            // конвертируем римские цифры в арабские
            if (!isArabicFirstOperand) {
                switch (firstOperand.toUpperCase()) {
                    case "I": {
                        operand1 = 1;
                        break;
                    }
                    case "II": {
                        operand1 = 2;
                        break;
                    }
                    case "III": {
                        operand1 = 3;
                        break;
                    }
                    case "IV": {
                        operand1 = 4;
                        break;
                    }
                    case "V": {
                        operand1 = 5;
                        break;
                    }
                    case "VI": {
                        operand1 = 6;
                        break;
                    }
                    case "VII": {
                        operand1 = 7;
                        break;
                    }
                    case "VIII": {
                        operand1 = 8;
                        break;
                    }
                    case "IX": {
                        operand1 = 9;
                        break;
                    }
                    case "X": {
                        operand1 = 10;
                        break;
                    }
                    default: {
                        System.out.println("Не верный ввод!!!");
                        continue input;
                    }
                }
                switch (secondOperand.toUpperCase()) {
                    case "I": {
                        operand2 = 1;
                        break;
                    }
                    case "II": {
                        operand2 = 2;
                        break;
                    }
                    case "III": {
                        operand2 = 3;
                        break;
                    }
                    case "IV": {
                        operand2 = 4;
                        break;
                    }
                    case "V": {
                        operand2 = 5;
                        break;
                    }
                    case "VI": {
                        operand2 = 6;
                        break;
                    }
                    case "VII": {
                        operand2 = 7;
                        break;
                    }
                    case "VIII": {
                        operand2 = 8;
                        break;
                    }
                    case "IX": {
                        operand2 = 9;
                        break;
                    }
                    case "X": {
                        operand2 = 10;
                        break;
                    }
                    default: {
                        System.out.println("Не верный ввод!!!");
                        continue input;
                    }
                }
            }


            // выполняем операцию
            int result = 0;
            switch (operator) {
                case "+": {
                    result = operand1 + operand2;
                    System.out.println(result);
                    break;
                }
                case "-": {
                    result = operand1 - operand2;
                    System.out.println(result);
                    break;
                }
                case "*": {
                    result = operand1 * operand2;
                    System.out.println(result);
                    break;
                }
                case "/": {
                    result = operand1 / operand2;
                    System.out.println(result);
                    break;
                }
                default: {
                    System.out.println("Не верный ввод!!!");
                    continue input;
                }
            }

//            System.out.println(operand1);
//            System.out.println(operand2);
//            System.out.println(operator);
        }


    }
}
