package nw.catalogtrace;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import nw.platform.ValidationException;
import org.springframework.stereotype.Repository;

/**
 * 商品处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("catalogtraceSessionValidator")
public class SessionValidator {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));
    private final SessionTranslator sessionTranslator;

    public SessionValidator(SessionTranslator sessionTranslator) {
        this.sessionTranslator = sessionTranslator;
    }

    public void collect(String value) {
        if (!PERMITTED.contains(value)) {
            throw new ValidationException("command not allowed");
        }
        this.sessionTranslator.submit(value);
    }
}
