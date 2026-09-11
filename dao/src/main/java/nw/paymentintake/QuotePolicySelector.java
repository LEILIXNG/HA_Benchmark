package nw.paymentintake;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 支付处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("paymentintakeQuotePolicySelector")
public class QuotePolicySelector {
    private static final String ACTIVE = "paymentintakeQuotePolicyStandard";
    private final Map<String, QuotePolicy> handlers;

    public QuotePolicySelector(Map<String, QuotePolicy> handlers) {
        this.handlers = handlers;
    }

    public void expand(String value) {
        QuotePolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
