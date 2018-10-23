package by.ots.poll.service;

import by.ots.poll.dto.AnswerCountDto;
import by.ots.poll.dto.ResponseAnswerDto;

public interface IAnswerService {

    /**
     * Add 1 vote to vote.
     *
     * @param id - Answer id.
     * @return count votes for current vote.
     */
    AnswerCountDto updateAnswerCount(String id);

    /**
     * Getting count votes for current vote.
     *
     * @param id - Answer id.
     * @return count votes for current vote.
     */
    ResponseAnswerDto getAnswer(String id);
}
