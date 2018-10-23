package by.ots.poll.service;

import by.ots.poll.dto.AnswerDto;
import by.ots.poll.dto.PollDto;
import by.ots.poll.entity.Poll;

import java.net.URI;
import java.util.List;
import java.util.Objects;


public interface IPollService<T extends AnswerDto> {
    /**
     * Create one poll from poll with n answers.
     *
     * @param pollDto - CreatePollDto.
     * @return poll after creation.
     */
    Poll createPoll (PollDto<T> pollDto);

    /**
     * Getting all polls from data base.
     *
     * @return List with all polls.
     */
    List<PollDto<T>> getAllPolls();

    /**
     * Method for starting or closing poll.
     *
     * @param id      - poll id.
     * @param status, true if you want start voting or false if you want close poll.
     * @return object StatusDto (url, poll status)
     */
    StatusDto changeStatus(String id, StatusDto status) throws UnknownHostException, MalformedURLException;

    /**
     * Return poll status.
     *
     * @param id - poll id.
     * @return true if status true (opened poll), false if status false (closed poll).
     */
    boolean isStatus(String id);


}
