package by.ots.poll.controller;

import by.ots.poll.dto.AddAnswerDto;
import by.ots.poll.dto.AnswerDto;
import by.ots.poll.dto.GetAnswerDto;
import by.ots.poll.dto.PollDto;
import by.ots.poll.entity.Poll;
import by.ots.poll.service.IPollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/poll")
public class PollController {

    @Resource
    private IPollService<AddAnswerDto> pollService1;
    @Resource
    private IPollService<GetAnswerDto> pollService2;

    @PostMapping
    public ResponseEntity<ResponsePollDto> createPoll(@Valid @RequestBody CreatePollDto createPollDto) {
        ResponsePollDto resultPollDto = pollService.createPoll(createPollDto);
        return new ResponseEntity<>(resultPollDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PollDto<GetAnswerDto>>> getAllPolls(){
        List<PollDto<GetAnswerDto>> list = pollService2.getAllPolls();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultPollDto> getPoll(@PathVariable String id) {
        ResultPollDto result = pollService.getPoll(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<URL> startOrStopPoll (@PathVariable String id, boolean status){
        pollService1.startOrStopPoll(id,status);
        URL url = null;
        try{

            url = new URL("/api/v1/poll/"+id) ;
        } catch (MalformedURLException e){

        }
        return new ResponseEntity<>(url, HttpStatus.OK);
    }
}
