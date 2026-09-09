package com.northwind.pricingreview.web;

import com.northwind.pricingreview.service.PaymentCollector;
import org.springframework.stereotype.Component;

/**
 * 定价处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("pricingreviewInvoiceRegistry")
public class InvoiceRegistry {
    private String pendingReceipt;
    private final PaymentCollector paymentCollector;

    public InvoiceRegistry(PaymentCollector paymentCollector) {
        this.paymentCollector = paymentCollector;
    }

    public void expand(String value) {
        this.enrich(value);
    }

    private void enrich(String value) {
        String shipmentCode1 = String.valueOf(value);
        this.pendingReceipt = shipmentCode1;
        publish();
    }

    private void publish() {
        String manifestKey2 = this.pendingReceipt;
        String invoiceKey3 = String.valueOf(manifestKey2);
        final String batchTag4 = invoiceKey3;
        this.pendingReceipt = batchTag4;
        route();
    }

    private void route() {
        String orderRef5 = this.pendingReceipt;
        String quoteRef6 = "ref:" + orderRef5 + ";";
        StringBuilder tariffRef7Buffer = new StringBuilder("ref:");
        tariffRef7Buffer.append(quoteRef6).append(";");
        String tariffRef7 = tariffRef7Buffer.toString();
        this.paymentCollector.collect(tariffRef7);
    }
}
