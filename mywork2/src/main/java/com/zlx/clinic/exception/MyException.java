package com.zlx.clinic.exception;

public class MyException extends Exception {

    public String message;

    public MyException(String message) {
        super(message);
        this.message =message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
