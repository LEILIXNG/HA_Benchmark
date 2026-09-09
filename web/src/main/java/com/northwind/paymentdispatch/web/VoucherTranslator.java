package com.northwind.paymentdispatch.web;

import com.northwind.paymentdispatch.service.OrderTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向支付场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("paymentdispatchVoucherTranslator")
public class VoucherTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherTranslator.class);
    private String pendingTariff;
    private final OrderTranslator orderTranslator;

    public VoucherTranslator(OrderTranslator orderTranslator) {
        this.orderTranslator = orderTranslator;
    }

    public void forward(String value) {
        LOG.debug("支付流程转下一环节");
        this.enrich(value);
    }

    private void enrich(String value) {
        StringBuilder voucherRef1Buffer = new StringBuilder("ref:");
        voucherRef1Buffer.append(value).append(";");
        String voucherRef1 = voucherRef1Buffer.toString();
        this.pendingTariff = voucherRef1;
        compose();
    }

    private void compose() {
        String paymentTag2 = this.pendingTariff;
        String refundCode3 = paymentTag2;
        this.orderTranslator.stage(refundCode3);
    }
}
