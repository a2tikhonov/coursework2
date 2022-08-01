package ru.atikhonov.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestedMoreQuestionsThanExistException extends RuntimeException {
    public RequestedMoreQuestionsThanExistException() {
        super();
    }

    public RequestedMoreQuestionsThanExistException(String message) {
        super(message);
    }

    public RequestedMoreQuestionsThanExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestedMoreQuestionsThanExistException(Throwable cause) {
        super(cause);
    }

    protected RequestedMoreQuestionsThanExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
