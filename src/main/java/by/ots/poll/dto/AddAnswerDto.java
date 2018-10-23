package by.ots.poll.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AddAnswerDto extends AnswerDto {
    @NotEmpty
    private String vote;
}
