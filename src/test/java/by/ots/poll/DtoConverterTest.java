package by.ots.poll;

import by.ots.poll.entity.Answer;
import by.ots.poll.entity.Poll;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DtoConverterTest {


    @Test
    public void pollConverterTest() {
        Poll poll = new Poll();
        poll.setId(1L);
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

    }
}
