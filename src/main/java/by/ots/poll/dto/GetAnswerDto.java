package by.ots.poll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAnswerDto extends AnswerDto {
    private String vote;
    private Integer count;
}
