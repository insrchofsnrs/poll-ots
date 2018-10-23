package by.ots.poll.exception.util;

import by.ots.poll.exception.InvalidFieldsPollDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomErrorConverter implements Converter<MethodArgumentNotValidException, List<InvalidFieldsPollDto>> {
    @Override
    public List<InvalidFieldsPollDto> convert(MethodArgumentNotValidException e) {
        List<InvalidFieldsPollDto> result = e.getBindingResult().getFieldErrors()
                .stream()
                .map((p) -> new InvalidFieldsPollDto(p.getDefaultMessage(), p.getField(), p.getRejectedValue()))
                .collect(Collectors.toList());
        return result;
    }
}
