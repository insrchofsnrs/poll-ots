package by.ots.poll.validation;

import by.ots.poll.dto.PollDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AnswerVoteCount implements ConstraintValidator<CountVote, PollDto> {
    @Override
    public void initialize(CountVote constraintAnnotation) {

    }

    @Override
    public boolean isValid(PollDto pollDto, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if (pollDto.getAnswersList().isEmpty() && pollDto.getAnswersList().size()<2 ){
            result = false;
        }
        return result;
    }
}
