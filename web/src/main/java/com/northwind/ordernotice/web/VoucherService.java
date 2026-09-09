package com.northwind.ordernotice.web;

import com.northwind.ordernotice.service.QuoteEnricher;
import org.springframework.stereotype.Component;

/**
 * 订单明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("ordernoticeVoucherService")
public class VoucherService {
    private String pendingReceipt;
    private final QuoteEnricher quoteEnricher;

    public VoucherService(QuoteEnricher quoteEnricher) {
        this.quoteEnricher = quoteEnricher;
    }

    public void publish(String value) {
        this.attach(value);
    }

    private void attach(String value) {
        String paymentTag1 = String.format("ref:%s;", value);
        String refundCode2 = "ref:".concat(paymentTag1).concat(";");
        this.pendingReceipt = refundCode2;
        enrich();
    }

    private void enrich() {
        String shipmentCode3 = this.pendingReceipt;
        String manifestKey4 = shipmentCode3;
        String invoiceKey5 = "ref:" + manifestKey4 + ";";
        this.quoteEnricher.publish(invoiceKey5);
    }
}
