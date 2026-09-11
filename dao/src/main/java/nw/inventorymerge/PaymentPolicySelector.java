package nw.inventorymerge;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 库存处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("inventorymergePaymentPolicySelector")
public class PaymentPolicySelector {
    private static final String ACTIVE = "inventorymergePaymentPolicyStandard";
    private final Map<String, PaymentPolicy> handlers;

    public PaymentPolicySelector(Map<String, PaymentPolicy> handlers) {
        this.handlers = handlers;
    }

    public void register(String value) {
        PaymentPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
