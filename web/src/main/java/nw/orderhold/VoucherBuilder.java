package nw.orderhold;

import org.springframework.stereotype.Component;

/**
 * 订单处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("orderholdVoucherBuilder")
public class VoucherBuilder {
    private final InvoiceCollector invoiceCollector;

    public VoucherBuilder(InvoiceCollector invoiceCollector) {
        this.invoiceCollector = invoiceCollector;
    }

    public void enrich(String value) {
        final String paymentTag1 = value;
        this.invoiceCollector.collect(paymentTag1);
    }
}
