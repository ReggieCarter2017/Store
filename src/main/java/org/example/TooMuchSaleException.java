package org.example;

public class TooMuchSaleException extends Exception {
    public TooMuchSaleException() {
    }

    public TooMuchSaleException(String message) {
        super(message);
    }
}
