package ru.atikhonov.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestionDoesntExist extends RuntimeException {
    public QuestionDoesntExist() {
        super();
    }

    public QuestionDoesntExist(String message) {
        super(message);
    }

    public QuestionDoesntExist(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionDoesntExist(Throwable cause) {
        super(cause);
    }

    protected QuestionDoesntExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
