package by.ots.poll;

import by.ots.poll.dto.PollDto;
import by.ots.poll.entity.Answer;
import by.ots.poll.entity.Poll;
import by.ots.poll.util.impl.ConvertDtoUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DtoConverterTest {

    @Autowired
    ConvertDtoUtil convertDtoUtil;

    @Test
    public void pollConverterTest(){
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

        PollDto pollDto = convertDtoUtil.PollToDto(poll);
        Assert.assertEquals(poll.getName(), pollDto.getName());
       /* Assert.assertEquals( poll.getAnswersList().stream().findFirst().get().getVote(),
                            pollDto.getAnswersList().stream().findFirst().get().getVote());*/
        System.out.println(pollDto.getAnswersList());
    }
}
