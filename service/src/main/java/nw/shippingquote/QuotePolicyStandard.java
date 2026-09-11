package nw.shippingquote;

import org.springframework.stereotype.Service;

/**
 * 发运的默认处理策略。
 */
@Service("shippingquoteQuotePolicyStandard")
public class QuotePolicyStandard implements QuotePolicy {
    private final RefundService refundService;

    public QuotePolicyStandard(RefundService refundService) {
        this.refundService = refundService;
    }

    @Override
    public void handle(String value) {
        this.refundService.resolve(value);
    }
}
