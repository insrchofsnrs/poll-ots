package by.ots.poll.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvalidFieldsPollDto {
    private String message;
    private String field;
    private Object rejectedValue;
}
