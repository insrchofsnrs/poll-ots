package by.ots.poll.service.impl;

import by.ots.poll.dto.AnswerCountDto;
import by.ots.poll.dto.ResponseAnswerDto;
import by.ots.poll.entity.Answer;
import by.ots.poll.exception.PollException;
import by.ots.poll.repository.AnswerRepository;
import by.ots.poll.repository.PollRepository;
import by.ots.poll.service.IAnswerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.modelmapper.ModelMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class AnswerServiceImpl implements IAnswerService {

    private final static Integer ADD_ONE_VOTE = 1;

    @Resource
    private AnswerRepository answerRepository;
    @Resource
    private PollRepository pollRepository;
    @Resource
    ModelMapper modelMapper;

    @Nullable
    @Override
    @Transactional
       public AnswerCountDto updateAnswerCount(String id) {
        AnswerCountDto result = new AnswerCountDto();
        if (NumberUtils.isParsable(id)) {
            Long ansId = NumberUtils.createLong(id);
            Answer answer = answerRepository.getOne(ansId);
            result.setCount(voting(answer));
        }
        return result;
    }


    private Integer voting(Answer answer) {
        Integer result;
        if (pollRepository.getOne(answer.getPollId()).isStatus()) {
            result = answer.getCount() + ADD_ONE_VOTE;
            answer.setCount(result);
            answerRepository.save(answer);
        } else {
            throw new PollException("Опрос закрыт");
        }
        return result;
    }

    @Override
    @Nullable
    public ResponseAnswerDto getAnswer(String id) {
        ResponseAnswerDto result = null;
        if (NumberUtils.isParsable(id)) {
            Long ansId = NumberUtils.createLong(id);
            Optional answer = answerRepository.findById(ansId);
            if (answer.isPresent()) {
                result = modelMapper.map(answer.get(), ResponseAnswerDto.class);
            } else {
                log.warn("Answer was not founded. id:{}", id);
                throw new PollException("Answer was not founded. id: " + id);
            }
        } else {
            log.warn("Wrong id {}", id);
            throw new PollException("Answer id is not number, {}" + id);
        }
        return result;
    }
}
