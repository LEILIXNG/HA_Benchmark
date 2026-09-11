package nw.ordercapture;

import org.springframework.stereotype.Component;

/**
 * 订单的默认处理策略。
 */
@Component("ordercaptureVoucherPlanStandard")
public class VoucherPlanStandard implements VoucherPlan {
    private final QuoteRegistry quoteRegistry;

    public VoucherPlanStandard(QuoteRegistry quoteRegistry) {
        this.quoteRegistry = quoteRegistry;
    }

    @Override
    public void handle(String value) {
        this.quoteRegistry.normalize(value);
    }
}
