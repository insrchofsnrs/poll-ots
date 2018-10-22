package by.ots.poll.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponsePollValid {
    private Date timestamp;
    private String message;
    private List<InvalidFieldsPollDto> invalidFieldsList;
}
