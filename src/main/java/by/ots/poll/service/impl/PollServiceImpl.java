package by.ots.poll.service.impl;

import by.ots.poll.dto.GetAnswerDto;
import by.ots.poll.dto.PollDto;
import by.ots.poll.entity.Poll;
import by.ots.poll.exception.PollException;
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
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
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

    @Value("${server.port}")
    private String currentPort;

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

    @Override
    @Nullable
    public ResultPollDto getPoll(String id) {
        ResultPollDto result;
        if (NumberUtils.isParsable(id)) {
            Poll poll = pollRepository.getOne(NumberUtils.createLong(id));
            result = modelMapper.map(poll, ResultPollDto.class);
        } else {
            log.warn("Wrong id {}", id);
            throw new PollException("Id not a number: " + id);
        }
        return result;
    }

    @Override
    public StatusDto changeStatus(String id, StatusDto status) throws UnknownHostException, MalformedURLException {
        if (NumberUtils.isParsable(id)) {
            Poll poll = pollRepository.getOne(NumberUtils.createLong(id));
            poll.setStatus(status.isStatus());
            pollRepository.save(poll);
            generationUrl(id, status);
        } else {
            log.warn("Wrong id {}", id);
            throw new PollException("Id not a number: " + id);
        }
        return status;
    }

    private void generationUrl(String id, StatusDto status) throws UnknownHostException, MalformedURLException {
        URL url = new URL("http://" + InetAddress.getLocalHost().getHostAddress() +
                ":" + currentPort + "/api/v1/poll/" + id);
        status.setUrl(url);
    }

    @Override
    public boolean isStatus(String id) {
        boolean result;
        if (NumberUtils.isParsable(id)) {
           result = pollRepository.getOne(NumberUtils.createLong(id)).isStatus();
        } else {
            log.warn("Wrong id {}", id);
            throw new PollException("Id not a number: " + id);
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

}
