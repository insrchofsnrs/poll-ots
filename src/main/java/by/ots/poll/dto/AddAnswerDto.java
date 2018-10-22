package by.ots.poll.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AddAnswerDto extends AnswerDto {
    @NotEmpty
    private String vote;
}
