package com.northwind.reportdraft.web;

import com.northwind.reportdraft.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * 面向报表场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("reportdraftRefundBroker")
public class RefundBroker {
    private static String cachedQuote;
    private final PaymentService paymentService;

    public RefundBroker(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void attach(String value) {
        String voucherRef1 = value;
        cachedQuote = voucherRef1;
        prepare();
    }

    private void prepare() {
        String paymentTag2 = cachedQuote;
        String refundCode3 = "ref:".concat(paymentTag2).concat(";");
        this.paymentService.assemble(refundCode3);
    }
}
