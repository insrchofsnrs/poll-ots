package by.ots.poll.dto;

import lombok.Data;

import java.util.List;

@Data
public class PollDto<T> {
    private Long id;
    private String name;
    private List<T> answersList;

}
