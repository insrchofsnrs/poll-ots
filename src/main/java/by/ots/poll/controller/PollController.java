package by.ots.poll.controller;

import by.ots.poll.dto.CreatePollDto;
import by.ots.poll.dto.ResponsePollDto;
import by.ots.poll.dto.ResultPollDto;
import by.ots.poll.dto.StatusDto;
import by.ots.poll.service.IPollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/poll")
public class PollController {

    @Resource
    private IPollService pollService;

    @PostMapping
    public ResponseEntity<ResponsePollDto> createPoll(@Valid @RequestBody CreatePollDto createPollDto) {
        ResponsePollDto resultPollDto = pollService.createPoll(createPollDto);
        return new ResponseEntity<>(resultPollDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResultPollDto>> getAllPolls() {
        List<ResultPollDto> list = pollService.getAllPolls();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultPollDto> getPoll(@PathVariable String id) {
        ResultPollDto result = pollService.getPoll(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusDto> changeStatus(@PathVariable String id, @RequestBody StatusDto status) {
        ResponseEntity<StatusDto> result;
        try {
            pollService.changeStatus(id, status);
            result = new ResponseEntity<>(status, HttpStatus.OK);
        } catch (UnknownHostException | MalformedURLException e) {
            log.error("Can`t generate url", e.getMessage());
            result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return result;
    }
}
