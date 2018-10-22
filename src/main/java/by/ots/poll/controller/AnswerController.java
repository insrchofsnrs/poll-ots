package by.ots.poll.controller;

import by.ots.poll.service.IAnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/v1/answer")
public class AnswerController {

    @Resource
    private IAnswerService answerService;

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateAnswerCount(@PathVariable String id){

        Integer count = answerService.updateAnswerCount(id);

        return new ResponseEntity<>(count, HttpStatus.OK);
    }

}
