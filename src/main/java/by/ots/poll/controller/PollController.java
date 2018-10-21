package by.ots.poll.controller;

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

@RestController("/poll")
public class PollController {
    @Resource
    IPollService pollService;

    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody PollDto pollDto) {

        Poll poll = pollService.createPoll(pollDto);
        return new ResponseEntity<>(poll, HttpStatus.CREATED);

    }


    @GetMapping
    public ResponseEntity<List<PollDto>> getAllPolls(){
        List<PollDto> list = pollService.getAllPolls();
        return new ResponseEntity<>(list, HttpStatus.OK);

    }
}
