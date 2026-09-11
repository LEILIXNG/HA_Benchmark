package nw.pricingcapture;

import org.springframework.stereotype.Component;

/**
 * 定价的默认处理策略。
 */
@Component("pricingcapturePaymentRuleStandard")
public class PaymentRuleStandard implements PaymentRule {
    private final CatalogNormalizer catalogNormalizer;

    public PaymentRuleStandard(CatalogNormalizer catalogNormalizer) {
        this.catalogNormalizer = catalogNormalizer;
    }

    @Override
    public void handle(String value) {
        this.catalogNormalizer.stage(value);
    }
}
