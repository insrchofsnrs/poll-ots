package by.ots.poll.repository;

import by.ots.poll.entity.Answer;
import by.ots.poll.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
