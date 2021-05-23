package javamentor.test.utils;

import java.util.HashMap;
import java.util.Map;

public class RomanArabicConverter {

    public static int romanOperandConvertToArabic(String romanOperand) {
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
                return 0;
            }
        }
    }

    public static String arabicResultConvertToRoman(int arabicResult) {
        String romanResult = "";
        int number = arabicResult;
        int digitQuantity = Integer.toString(arabicResult).length();
        HashMap<Integer, Integer> digits = new HashMap<>();
        for (int i = digitQuantity - 1; i >= 0; i--) {
            int position = (int) Math.pow(10, i);
            if (i == 0) {
                digits.put(position, number);
                break;
            }
            digits.put(position, number / position);
            number %= position;
        }
        for (int i = (int)Math.pow(10, digitQuantity - 1); i >= 1; i /= 10) {
            romanResult += digits.get(i);
        }
        return romanResult;
    }
}
