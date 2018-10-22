package by.ots.poll.exception;

import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@ControllerAdvice
@RestController
public class CustomResponseEntityException  extends ResponseEntityExceptionHandler {

    @Resource
    Converter<MethodArgumentNotValidException, List<InvalidFieldsPollDto>> converter;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ExceptionResponsePollValid responsePollValid = new ExceptionResponsePollValid(new Date(),
                ex.getBindingResult().getAllErrors().stream().findFirst().get().getDefaultMessage(),
                converter.convert(ex));
        return new ResponseEntity<>(responsePollValid, HttpStatus.BAD_REQUEST);
    }
}
