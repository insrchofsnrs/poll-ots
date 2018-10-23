package by.ots.poll.service;

import by.ots.poll.dto.CreatePollDto;
import by.ots.poll.dto.ResponsePollDto;
import by.ots.poll.dto.ResultPollDto;
import by.ots.poll.dto.StatusDto;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.List;


public interface IPollService {

    /**
     * Create one poll from poll with n answers.
     *
     * @param pollDto - CreatePollDto.
     * @return poll after creation.
     */
    ResponsePollDto createPoll(CreatePollDto pollDto);

    /**
     * Getting all polls from data base.
     *
     * @return List with all polls.
     */
    List<ResultPollDto> getAllPolls();

    /**
     * Getting one poll by id.
     *
     * @param id - poll id.
     * @return poll with list answers.
     */
    ResultPollDto getPoll(String id);

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
