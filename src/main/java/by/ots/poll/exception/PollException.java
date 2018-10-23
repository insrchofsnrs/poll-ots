package by.ots.poll.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PollException extends RuntimeException {

    public PollException(String ex) {
        super(ex);
    }
}
