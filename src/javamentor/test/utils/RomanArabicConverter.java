package javamentor.test.utils;

import javamentor.test.WrongExpressionException;

import java.util.HashMap;

public class RomanArabicConverter {

    public static int romanOperandConvertToArabic(String romanOperand) throws WrongExpressionException {
        switch (romanOperand.toUpperCase()) {
            case "I": {
                return 1;
            }
            case "II": {
                return 2;
            }
            case "III": {
                return 3;
            }
            case "IV": {
                return 4;
            }
            case "V": {
                return 5;
            }
            case "VI": {
                return 6;
            }
            case "VII": {
                return 7;
            }
            case "VIII": {
                return 8;
            }
            case "IX": {
                return 9;
            }
            case "X": {
                return 10;
            }
            default: {
                throw new WrongExpressionException("Введенное число не соответствует условию: диапазон вводимых значений (1-10) или (I-X)");
            }
        }
    }

    public static String arabicToRomanConvert(int arabicNumber) {
        StringBuilder romanResult = new StringBuilder();
        int digitQuantity = Integer.toString(arabicNumber).length();
        HashMap<Integer, Integer> digits = new HashMap<>();
        boolean isPositive = arabicNumber >= 0;
        int number = isPositive ? arabicNumber : Math.abs(arabicNumber);
        for (int i = digitQuantity - 1; i >= 0; i--) {      // разбиваем число на разряды
            int position = (int) Math.pow(10, i);           // и заполняем таблицу с кол-вом единиц в разрядах
            if (i == 0) {
                digits.put(position, number);
                break;
            }
            digits.put(position, number / position);
            number %= position;
        }
        for (int i = (int) Math.pow(10, digitQuantity - 1); i >= 1; i /= 10) { //собираем строку ответа из римских символов
            if (i >= 1000) {
                for (int j = 0; j < digits.get(i); j++) {
                    romanResult.append("M");
                }
            } else if (i < 1000 && i >= 100) {
                if (digits.get(i) == 9) {
                    romanResult.append("CM");
                } else if (digits.get(i) == 5) {
                    romanResult.append("D");
                } else if (digits.get(i) == 4) {
                    romanResult.append("CD");
                } else if (digits.get(i) < 4) {
                    for (int j = 0; j < digits.get(i); j++) {
                        romanResult.append("C");
                    }
                } else {
                    romanResult.append("D");
                    for (int j = 5; j < digits.get(i); j++) {
                        romanResult.append("C");
                    }
                }
            } else if (i < 100 && i >= 10) {
                if (digits.get(i) == 9) {
                    romanResult.append("XC");
                } else if (digits.get(i) == 5) {
                    romanResult.append("L");
                } else if (digits.get(i) == 4) {
                    romanResult.append("XL");
                } else if (digits.get(i) < 4) {
                    for (int j = 0; j < digits.get(i); j++) {
                        romanResult.append("X");
                    }
                } else {
                    romanResult.append("L");
                    for (int j = 5; j < digits.get(i); j++) {
                        romanResult.append("X");
                    }
                }
            } else {
                if (digits.get(i) == 9) {
                    romanResult.append("IX");
                } else if (digits.get(i) == 5) {
                    romanResult.append("V");
                } else if (digits.get(i) == 4) {
                    romanResult.append("IV");
                } else if (digits.get(i) < 4) {
                    for (int j = 0; j < digits.get(i); j++) {
                        romanResult.append("I");
                    }
                } else {
                    romanResult.append("V");
                    for (int j = 5; j < digits.get(i); j++) {
                        romanResult.append("I");
                    }
                }
            }
        }
        if (isPositive) {
            return romanResult.toString();
        } else {
            return "-" + romanResult;
        }
    }
}
