package by.ots.poll.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = { AnswerVoteCount.class })
public @interface CountVote {
    String message() default "Need 2 or more answers";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
