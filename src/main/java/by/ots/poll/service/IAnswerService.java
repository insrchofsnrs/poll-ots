package by.ots.poll.service;

public interface IAnswerService {

    /**
     * Add 1 vote to vote.
     * @param id - Answer id.
     * @return count votes for current vote.
     */
    Integer updateAnswerCount(String id);

    /**
     * Getting count votes for current vote.
     * @param id - Answer id.
     * @return count votes for current vote.
     */
    Integer getCount(String id);
}
