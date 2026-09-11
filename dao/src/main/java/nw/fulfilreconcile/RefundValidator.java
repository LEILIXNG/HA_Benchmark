package nw.fulfilreconcile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 履约处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("fulfilreconcileRefundValidator")
public class RefundValidator {
    private static final Logger LOG = LoggerFactory.getLogger(RefundValidator.class);
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final RefundExecutor refundExecutor;

    public RefundValidator(RefundExecutor refundExecutor) {
        this.refundExecutor = refundExecutor;
    }

    public void refine(String value) {
        Matcher matcher = ACCEPTED.matcher(value);
        if (!matcher.matches()) {
            throw new ValidationException("rejected input");
        }
        this.refundExecutor.normalize(value);
    }
}
