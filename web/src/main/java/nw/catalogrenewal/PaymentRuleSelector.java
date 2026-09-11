package nw.catalogrenewal;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("catalogrenewalPaymentRuleSelector")
public class PaymentRuleSelector {
    private static final String ACTIVE = "catalogrenewalPaymentRuleStandard";
    private final Map<String, PaymentRule> handlers;

    public PaymentRuleSelector(Map<String, PaymentRule> handlers) {
        this.handlers = handlers;
    }

    public void reconcile(String value) {
        PaymentRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
