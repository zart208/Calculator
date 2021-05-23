package javamentor.test.utils;

public class TwoOperandsExpressionParser {
    private String firstOperand = "";
    private String secondOperand = "";
    private String operator = "";

    public TwoOperandsExpressionParser(String expression) {
        if (!expression.isEmpty()) {
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
        }
    }

    public String getFirstOperand() {
        return firstOperand.trim();
    }

    public String getSecondOperand() {
        return secondOperand.trim();
    }

    public String getOperator() {
        return operator;
    }
}
