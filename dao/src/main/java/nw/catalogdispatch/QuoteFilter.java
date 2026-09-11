package nw.catalogdispatch;

import java.util.regex.Pattern;
import nw.platform.ValidationException;
import org.springframework.stereotype.Repository;

/**
 * 商品受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("catalogdispatchQuoteFilter")
public class QuoteFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");
    private final ChannelEvaluator channelEvaluator;

    public QuoteFilter(ChannelEvaluator channelEvaluator) {
        this.channelEvaluator = channelEvaluator;
    }

    public void enrich(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new ValidationException("rejected input");
        }
        this.channelEvaluator.translate(value);
    }
}
