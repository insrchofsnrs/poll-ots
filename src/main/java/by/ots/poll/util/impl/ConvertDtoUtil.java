package by.ots.poll.util.impl;

import by.ots.poll.dto.PollDto;
import by.ots.poll.entity.Poll;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertDtoUtil {

    @Autowired
    ModelMapper modelMapper;

    public Poll DtoToPoll (PollDto pollDto){
        Poll poll = modelMapper.map(pollDto, Poll.class);
        return poll;
    }

    public PollDto PollToDto (Poll poll){

        PollDto pollDto = modelMapper.map (poll, PollDto.class);
        return pollDto;
    }

}
