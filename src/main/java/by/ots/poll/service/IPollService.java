package by.ots.poll.service;

import by.ots.poll.dto.AnswerDto;
import by.ots.poll.dto.PollDto;
import by.ots.poll.entity.Poll;

import java.util.List;
import java.util.Objects;


public interface IPollService<T extends AnswerDto> {
    /**
     * Create one poll from poll with n answers.
     * @param pollDto - poll.
     * @return poll after creation.
     */
    Poll createPoll (PollDto pollDto);

    /**
     * Getting all polls from data base.
     * @return List with all polls.
     */
    List<PollDto<T>> getAllPolls();

    /**
     * Close poll, after then poll get status inactive.
     * @param id - Poll id.
     * @return true or false.
     */
    boolean removePoll(String id);

}
