package by.ots.poll.repository;

import by.ots.poll.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PollRepository extends JpaRepository<Poll, Long> {
    Poll getPollByAnswersList(Long id);

}
