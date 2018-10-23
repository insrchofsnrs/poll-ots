package by.ots.poll.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ResultPollDto extends BasePollDto {
    private List<GetAnswerDto> answersList;
}
