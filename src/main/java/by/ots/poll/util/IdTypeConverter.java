package by.ots.poll.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IdTypeConverter implements Converter<String, Integer> {

    @Override
    @Nullable
    public Integer convert(String id) {
       Integer result = null;
            if (id!=null) {
                id.trim();
                try {
                    result = Integer.parseInt(id);
                } catch (NumberFormatException e){
                    log.warn("Cant get Integer id from String. Id {}", id);
            }
        }
        return result;
    }
}
