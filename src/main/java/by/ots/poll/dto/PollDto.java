package by.ots.poll.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class PollDto {
    private Long id;
    private String name;
    private Set<AnswerDto> answersList;

}
