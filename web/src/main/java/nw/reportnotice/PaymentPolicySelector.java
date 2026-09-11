package nw.reportnotice;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("reportnoticePaymentPolicySelector")
public class PaymentPolicySelector {
    private static final String ACTIVE = "reportnoticePaymentPolicyStandard";
    private final Map<String, PaymentPolicy> handlers;

    public PaymentPolicySelector(Map<String, PaymentPolicy> handlers) {
        this.handlers = handlers;
    }

    public void dispatch(String value) {
        PaymentPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
