package nw.orderlookup;

import org.springframework.stereotype.Component;

/**
 * 订单的默认处理策略。
 */
@Component("orderlookupInvoiceStrategyStandard")
public class InvoiceStrategyStandard implements InvoiceStrategy {
    private final AccountTranslator accountTranslator;

    public InvoiceStrategyStandard(AccountTranslator accountTranslator) {
        this.accountTranslator = accountTranslator;
    }

    @Override
    public void handle(String value) {
        this.accountTranslator.route(value);
    }
}
