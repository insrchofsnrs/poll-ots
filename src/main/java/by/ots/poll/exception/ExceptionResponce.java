package by.ots.poll.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionResponce {
    private Date timestamp;
    private String message;
}
