package org.example;

public class NoSuchItemrException extends Exception {
    public NoSuchItemrException() {
    }

    public NoSuchItemrException(String message) {
        super(message);
    }
}
