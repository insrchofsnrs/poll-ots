package by.ots.poll.controller;

import by.ots.poll.dto.AnswerCountDto;
import by.ots.poll.dto.ResponseAnswerDto;
import by.ots.poll.service.IAnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/v1/answer")
public class AnswerController {

    @Resource
    private IAnswerService answerService;

    @PutMapping("/{id}")
    public ResponseEntity<AnswerCountDto> updateAnswerCount(@PathVariable String id) {
        AnswerCountDto count = answerService.updateAnswerCount(id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseAnswerDto> getAnswer(@PathVariable String id) {
        ResponseAnswerDto answer = answerService.getAnswer(id);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

}
