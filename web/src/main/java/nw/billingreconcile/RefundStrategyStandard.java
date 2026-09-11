package nw.billingreconcile;

import org.springframework.stereotype.Component;

/**
 * 账务的默认处理策略。
 */
@Component("billingreconcileRefundStrategyStandard")
public class RefundStrategyStandard implements RefundStrategy {
    private final QuoteTranslator quoteTranslator;

    public RefundStrategyStandard(QuoteTranslator quoteTranslator) {
        this.quoteTranslator = quoteTranslator;
    }

    @Override
    public void handle(String value) {
        this.quoteTranslator.route(value);
    }
}
