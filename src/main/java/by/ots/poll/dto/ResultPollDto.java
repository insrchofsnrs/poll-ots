package by.ots.poll.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResultPollDto extends BasePollDto {
    private List<GetAnswerDto> answersList;
}
