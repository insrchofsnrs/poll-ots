package by.ots.poll.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreatePollDto extends BasePollDto {
    @Valid
    @Size(min = 2)
    private List<AddAnswerDto> answersList;
}
