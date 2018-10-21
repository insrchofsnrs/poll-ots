package by.ots.poll.service.impl;

import by.ots.poll.dto.PollDto;
import by.ots.poll.entity.Poll;
import by.ots.poll.repository.PollRepository;
import by.ots.poll.service.IPollService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
            result = modelMapper.map(pollDto, Poll.class);
            pollRepository.save(result);
        }
        return result;
    }
    @Transactional
    @Override
    public List<PollDto> getAllPolls() {
        List<PollDto> result = null;
        List<Poll> list = pollRepository.findAll();
        if (!list.isEmpty()) {
            result = list.stream().map((p) -> modelMapper.map(p, PollDto.class)).collect(Collectors.toList());
        }
        return result;
    }

    @Override
    public boolean removePoll(String id) {
        boolean result = false;
        if (NumberUtils.isCreatable(id)) {
            pollRepository.deleteById(Long.parseLong(id));
            result = true;
        }
        return result;
    }
}
