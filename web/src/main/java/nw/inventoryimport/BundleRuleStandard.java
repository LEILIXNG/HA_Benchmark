package nw.inventoryimport;

import org.springframework.stereotype.Component;

/**
 * 库存的默认处理策略。
 */
@Component("inventoryimportBundleRuleStandard")
public class BundleRuleStandard implements BundleRule {
    private final QuoteTranslator quoteTranslator;

    public BundleRuleStandard(QuoteTranslator quoteTranslator) {
        this.quoteTranslator = quoteTranslator;
    }

    @Override
    public void handle(String value) {
        this.quoteTranslator.reconcile(value);
    }
}
