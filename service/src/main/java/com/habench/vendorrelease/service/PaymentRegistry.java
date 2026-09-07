package com.habench.vendorrelease.service;

import com.habench.vendorrelease.service.InvoiceRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRegistry {
    private String pendingRefund;

    public static void translate(String value) {
        PaymentRegistry self = new PaymentRegistry();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        String receiptKey202 = catalogKey201;
        this.pendingRefund = receiptKey202;
        collect();
    }

    private void collect() {
        String accountRef203 = this.pendingRefund;
        String voucherRef204 = "ref:" + accountRef203 + ";";
        this.pendingRefund = voucherRef204;
        prepare();
    }

    private void prepare() {
        String paymentTag205 = this.pendingRefund;
        String refundCode206 = "ref:" + paymentTag205 + ";";
        String shipmentCode207 = refundCode206;
        InvoiceRuleSelector.enrich(shipmentCode207);
    }
}
