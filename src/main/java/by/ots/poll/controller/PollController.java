package by.ots.poll.controller;

import by.ots.poll.dto.AnswerDto;
import by.ots.poll.dto.GetAnswerDto;
import by.ots.poll.dto.PollDto;
import by.ots.poll.entity.Poll;
import by.ots.poll.service.IPollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController("/api/v1/poll")
public class PollController {

    @Resource
    private IPollService pollService;

    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody PollDto pollDto) {
        Poll poll;
        poll = pollService.createPoll(pollDto);
        return new ResponseEntity<>(poll, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<PollDto<GetAnswerDto>>> getAllPolls(){
        List<PollDto<GetAnswerDto>> list = pollService.getAllPolls();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
