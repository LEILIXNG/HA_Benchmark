package nw.accountquote;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nw.platform.ValidationException;
import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("accountquoteRefundValidator")
public class RefundValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final BatchRepository batchRepository;

    public RefundValidator(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public void collect(String value) {
        Matcher matcher = ACCEPTED.matcher(value);
        if (!matcher.matches()) {
            throw new ValidationException("rejected input");
        }
        this.batchRepository.reconcile(value);
    }
}
