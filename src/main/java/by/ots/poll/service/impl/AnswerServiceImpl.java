package by.ots.poll.service.impl;

import by.ots.poll.entity.Answer;
import by.ots.poll.exception.PollNotFoundException;
import by.ots.poll.repository.AnswerRepository;
import by.ots.poll.repository.PollRepository;
import by.ots.poll.service.IAnswerService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AnswerServiceImpl implements IAnswerService {

    private final static Integer ADD_ONE_VOTE = 1;

    @Resource
    private AnswerRepository answerRepository;
    @Resource
    private PollRepository pollRepository;

    @Nullable
    @Override
    public Integer updateAnswerCount(String id) {
        Integer result = null;
        if (NumberUtils.isParsable(id)) {
            Long ansId = NumberUtils.createLong(id);
            Answer answer = answerRepository.getOne(ansId);
            if (pollRepository.getOne(answer.getPollId()).isStatus()) {
                result = answer.getCount() + ADD_ONE_VOTE;
                answer.setCount(result);
                answerRepository.save(answer);
            } else {
                throw new PollNotFoundException("Опрос закрыт");
            }
        }
        return result;
    }

    @Override
    public Integer getCount(String id) {
        return null;
    }
}
