package by.ots.poll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetAnswerDto extends AnswerDto {
    private String vote;
    private Integer count;
}
