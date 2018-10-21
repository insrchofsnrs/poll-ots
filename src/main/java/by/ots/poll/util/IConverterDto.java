package by.ots.poll.util;

import by.ots.poll.dto.PollDto;
import by.ots.poll.entity.Poll;

public interface IConverterDto {

    Poll DtoToPoll();

    PollDto PollToDto();

}
