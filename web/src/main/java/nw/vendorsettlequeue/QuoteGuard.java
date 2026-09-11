package nw.vendorsettlequeue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendorsettlequeueQuoteGuard")
public class QuoteGuard {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteGuard.class);
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final OrderPolicySelector orderPolicySelector;

    public QuoteGuard(OrderPolicySelector orderPolicySelector) {
        this.orderPolicySelector = orderPolicySelector;
    }

    public void register(String value) {
        Matcher matcher = ACCEPTED.matcher(value);
        if (!matcher.matches()) {
            throw new ValidationException("rejected input");
        }
        this.orderPolicySelector.route(value);
    }
}
