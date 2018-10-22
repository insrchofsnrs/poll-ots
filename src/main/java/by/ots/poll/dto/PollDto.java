package by.ots.poll.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PollDto<T> {
    private Long id;
    @NotEmpty
    private String name;
    @Valid
    @Size(min = 2)
    private List<T> answersList;
}
