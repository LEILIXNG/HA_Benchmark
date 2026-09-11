package nw.pricingrollup;

import org.springframework.stereotype.Component;

/**
 * 定价的默认处理策略。
 */
@Component("pricingrollupInvoiceStrategyStandard")
public class InvoiceStrategyStandard implements InvoiceStrategy {
    private final ContractTranslator contractTranslator;

    public InvoiceStrategyStandard(ContractTranslator contractTranslator) {
        this.contractTranslator = contractTranslator;
    }

    @Override
    public void handle(String value) {
        this.contractTranslator.reconcile(value);
    }
}
