package by.ots.poll.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CreatePollDto extends BasePollDto {
    @Valid
    @Size(min = 2)
    private List<AddAnswerDto> answersList;
}
