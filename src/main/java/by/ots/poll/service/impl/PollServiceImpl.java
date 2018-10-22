package by.ots.poll.service.impl;

import by.ots.poll.dto.GetAnswerDto;
import by.ots.poll.dto.PollDto;
import by.ots.poll.entity.Poll;
import by.ots.poll.exception.PollNotFoundException;
import by.ots.poll.repository.PollRepository;
import by.ots.poll.service.IPollService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

@Slf4j
@Service
public class PollServiceImpl implements IPollService {

    @Resource
    private PollRepository pollRepository;
    @Resource
    private Converter<String, Integer> converter;
    @Resource
    private ModelMapper modelMapper;


    @Override
    @Nullable
    public Poll createPoll(PollDto pollDto) {
        Poll result = null;
        if (pollDto != null) {
            Long id = pollRepository.save(modelMapper.map(pollDto, Poll.class)).getId();
            result = getPoll(id);
        }
        return result;
    }


    private Poll getPoll(Long id) {
        Poll result;
        result = pollRepository.getOne(id);
        return result;
    }

    @Override
    @Transactional
    public boolean startOrStopPoll(String id, boolean status) {
        boolean result;
        if (NumberUtils.isParsable(id)) {
            Poll poll = pollRepository.getOne(NumberUtils.createLong(id));
            poll.setStatus(status);
            pollRepository.save(poll);
            result = status;
        } else {
            throw  new PollNotFoundException("Опрос не найден");
        }
        return result;
    }

    @Override
    public boolean isStatus(String id) {
        boolean result;
        //если недостучался кинуть ошибку
        if (NumberUtils.isParsable(id)) {
           result = pollRepository.getOne(NumberUtils.createLong(id)).isStatus();
        } else {
            throw new PollNotFoundException(" Опрос не найден");
        }
        return result;
    }

    @Transactional
    @Override
    public List<PollDto<GetAnswerDto>> getAllPolls() {
        List<PollDto<GetAnswerDto>> result = null;
        List<Poll> list = pollRepository.findAll();
        if (!list.isEmpty()) {
            Type listType = new TypeToken<List<PollDto<GetAnswerDto>>>() {
            }.getType();
            result = modelMapper.map(list, listType);
        }
        return result;
    }

    @Override
    public boolean removePoll(String id) {
        boolean result = false;
        if (NumberUtils.isParsable(id)) {
            pollRepository.deleteById(NumberUtils.createLong(id));
            result = true;
        }
        return result;
    }
}
