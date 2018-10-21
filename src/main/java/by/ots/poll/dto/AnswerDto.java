package by.ots.poll.dto;

import lombok.Data;

@Data
public class AnswerDto {
    private Long id;
    private String vote;
    private Integer count;
    private PollDto poll;
}
