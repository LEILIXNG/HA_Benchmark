package nw.pricingnotice;

import java.util.regex.Pattern;
import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("pricingnoticeOrderScreen")
public class OrderScreen {
    private static final Logger LOG = LoggerFactory.getLogger(OrderScreen.class);
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final QuotePlanSelector quotePlanSelector;

    public OrderScreen(QuotePlanSelector quotePlanSelector) {
        this.quotePlanSelector = quotePlanSelector;
    }

    public void enrich(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new ValidationException("rejected input");
        }
        this.quotePlanSelector.refine(value);
    }
}
