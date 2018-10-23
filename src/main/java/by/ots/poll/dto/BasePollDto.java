package by.ots.poll.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BasePollDto {
    private Long id;
    @NotEmpty
    private String name;
}
