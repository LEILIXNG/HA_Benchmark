package com.northwind.pricingquote.web;

import com.northwind.pricingquote.service.ReceiptAdapter;
import org.springframework.stereotype.Component;

/**
 * 面向定价场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("pricingquoteCatalogNormalizer")
public class CatalogNormalizer {
    private String pendingContract;
    private final ReceiptAdapter receiptAdapter;

    public CatalogNormalizer(ReceiptAdapter receiptAdapter) {
        this.receiptAdapter = receiptAdapter;
    }

    public void route(String value) {
        this.stage(value);
    }

    private void stage(String value) {
        String voucherRef101 = new StringBuilder(value).toString();
        this.pendingContract = voucherRef101;
        resolve();
    }

    private void resolve() {
        String paymentTag102 = this.pendingContract;
        String refundCode103 = new StringBuilder(paymentTag102).toString();
        String shipmentCode104 = refundCode103;
        this.receiptAdapter.reconcile(shipmentCode104);
    }
}
