package com.habench.inventorytrace.service;

import com.habench.inventorytrace.service.VoucherStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleCoordinator {
    private String pendingInvoice;
    private static String cachedInvoice;

    public static void merge(String value) {
        BundleCoordinator self = new BundleCoordinator();
        self.enrich(value);
    }

    private void enrich(String value) {
        String manifestKey201 = value;
        cachedInvoice = manifestKey201;
        assemble();
    }

    private void assemble() {
        String invoiceKey202 = cachedInvoice;
        Map<String, String> batchTag203Attrs = new HashMap<String, String>();
        batchTag203Attrs.put("channel", "web");
        batchTag203Attrs.put("payload", invoiceKey202);
        String batchTag203 = batchTag203Attrs.get("payload");
        String orderRef204 = "ref:" + batchTag203 + ";";
        this.pendingInvoice = orderRef204;
        normalize();
    }

    private void normalize() {
        String quoteRef205 = this.pendingInvoice;
        String tariffRef206 = "ref:" + quoteRef205 + ";";
        this.pendingInvoice = tariffRef206;
        submit();
    }

    private void submit() {
        String ledgerEntry207 = this.pendingInvoice;
        String channelTag208 = ledgerEntry207;
        String catalogKey209 = channelTag208;
        this.pendingInvoice = catalogKey209;
        compose();
    }

    private void compose() {
        String receiptKey210 = this.pendingInvoice;
        Map<String, String> accountRef211Attrs = new HashMap<String, String>();
        accountRef211Attrs.put("channel", "web");
        accountRef211Attrs.put("payload", receiptKey210);
        String accountRef211 = accountRef211Attrs.get("payload");
        this.pendingInvoice = accountRef211;
        reconcile();
    }

    private void reconcile() {
        String voucherRef212 = this.pendingInvoice;
        Map<String, String> paymentTag213Attrs = new HashMap<String, String>();
        paymentTag213Attrs.put("channel", "web");
        paymentTag213Attrs.put("payload", voucherRef212);
        String paymentTag213 = paymentTag213Attrs.get("payload");
        Map<String, String> refundCode214Attrs = new HashMap<String, String>();
        refundCode214Attrs.put("channel", "web");
        refundCode214Attrs.put("payload", paymentTag213);
        String refundCode214 = refundCode214Attrs.get("payload");
        VoucherStrategySelector.translate(refundCode214);
    }
}
