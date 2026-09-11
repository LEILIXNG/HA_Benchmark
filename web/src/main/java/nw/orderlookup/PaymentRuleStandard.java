package nw.orderlookup;

import org.springframework.stereotype.Component;

/**
 * 订单的默认处理策略。
 */
@Component("orderlookupPaymentRuleStandard")
public class PaymentRuleStandard implements PaymentRule {
    private final QuoteTranslator quoteTranslator;

    public PaymentRuleStandard(QuoteTranslator quoteTranslator) {
        this.quoteTranslator = quoteTranslator;
    }

    @Override
    public void handle(String value) {
        this.quoteTranslator.resolve(value);
    }
}
