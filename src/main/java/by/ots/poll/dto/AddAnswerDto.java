package by.ots.poll.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AddAnswerDto extends AnswerDto {
    @NotEmpty
    private String vote;
}
