package nw.shippingquote;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 发运处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("shippingquoteQuotePolicySelector")
public class QuotePolicySelector {
    private static final String ACTIVE = "shippingquoteQuotePolicyStandard";
    private final Map<String, QuotePolicy> handlers;

    public QuotePolicySelector(Map<String, QuotePolicy> handlers) {
        this.handlers = handlers;
    }

    public void expand(String value) {
        QuotePolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
