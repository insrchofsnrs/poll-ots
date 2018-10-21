package by.ots.poll;

import by.ots.poll.entity.Answer;
import by.ots.poll.entity.Poll;
import by.ots.poll.repository.PollRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PollAndAnswerDbTest {

    @Resource
    PollRepository pollRepository;

    @Test
    @Transactional
    public void createPoll (){

        Poll poll = new Poll();
        poll.setName("first poll");
        Answer answer1 = new Answer();
        answer1.setVote("test1");
        Answer answer2 = new Answer();
        answer2.setVote("test2");
        Answer answer3 = new Answer();
        answer3.setVote("test3");
        List<Answer> answerList = new ArrayList<>();
        answerList.add(answer1);
        answerList.add(answer2);
        answerList.add(answer3);
        poll.setAnswersList(answerList);

        System.out.println(poll);

        Long pollId = pollRepository.save(poll).getId();

        poll.setName("Second poll");

        pollRepository.save(poll);

        Poll newPoll = pollRepository.findById(pollId).get();
        pollRepository.findAll().stream().forEach(p-> System.out.println(p.getAnswersList().stream().findFirst().toString()));
        Assert.assertEquals(poll,newPoll);


    }
}
