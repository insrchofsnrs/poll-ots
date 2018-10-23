package by.ots.poll.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ExceptionResponsePollValid extends ExceptionResponce {
    private List<InvalidFieldsPollDto> invalidFieldsList;

    public ExceptionResponsePollValid(Date timestamp,
                                      String message,
                                      List<InvalidFieldsPollDto> invalidFieldsList) {
        super(timestamp, message);
        this.invalidFieldsList = invalidFieldsList;
    }
}
