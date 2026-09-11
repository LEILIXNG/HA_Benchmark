package nw.orderdraft;

import org.springframework.stereotype.Component;

/**
 * 订单的默认处理策略。
 */
@Component("orderdraftInvoiceStrategyStandard")
public class InvoiceStrategyStandard implements InvoiceStrategy {
    private final VoucherTranslator voucherTranslator;

    public InvoiceStrategyStandard(VoucherTranslator voucherTranslator) {
        this.voucherTranslator = voucherTranslator;
    }

    @Override
    public void handle(String value) {
        this.voucherTranslator.publish(value);
    }
}
