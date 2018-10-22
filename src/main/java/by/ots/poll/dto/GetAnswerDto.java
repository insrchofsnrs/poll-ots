package by.ots.poll.dto;

import lombok.Data;

@Data
public class GetAnswerDto extends AnswerDto {

    private String vote;
    private Integer count;

}
