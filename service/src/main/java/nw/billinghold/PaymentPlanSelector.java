package nw.billinghold;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账务处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("billingholdPaymentPlanSelector")
public class PaymentPlanSelector {
    private static final String ACTIVE = "billingholdPaymentPlanStandard";
    private final Map<String, PaymentPlan> handlers;

    public PaymentPlanSelector(Map<String, PaymentPlan> handlers) {
        this.handlers = handlers;
    }

    public void assemble(String value) {
        PaymentPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
