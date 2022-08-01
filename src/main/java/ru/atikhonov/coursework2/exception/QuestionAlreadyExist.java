package ru.atikhonov.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAlreadyExist extends RuntimeException{
    public QuestionAlreadyExist() {
        super();
    }

    public QuestionAlreadyExist(String message) {
        super(message);
    }

    public QuestionAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionAlreadyExist(Throwable cause) {
        super(cause);
    }

    protected QuestionAlreadyExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
