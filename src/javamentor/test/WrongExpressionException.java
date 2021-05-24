package javamentor.test;

import java.io.IOException;

public class WrongExpressionException extends IOException {
    public WrongExpressionException(String message) {
        super(message);
    }
}
