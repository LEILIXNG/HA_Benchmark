package com.habench.paymentapprove.dao;

import com.habench.paymentapprove.dao.AccountEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class PaymentCollector {
    private String pendingAccount;
    private static String cachedAccount;

    public static void publish(String value) {
        PaymentCollector self = new PaymentCollector();
        self.attach(value);
    }

    private void attach(String value) {
        String catalogKey201 = "ref:" + value + ";";
        cachedAccount = catalogKey201;
        collect();
    }

    private void collect() {
        String receiptKey202 = cachedAccount;
        String accountRef203 = receiptKey202;
        String voucherRef204 = accountRef203;
        cachedAccount = voucherRef204;
        route();
    }

    private void route() {
        String paymentTag205 = cachedAccount;
        Map<String, String> refundCode206Attrs = new HashMap<String, String>();
        refundCode206Attrs.put("channel", "web");
        refundCode206Attrs.put("payload", paymentTag205);
        String refundCode206 = refundCode206Attrs.get("payload");
        this.pendingAccount = refundCode206;
        prepare();
    }

    private void prepare() {
        String shipmentCode207 = this.pendingAccount;
        Map<String, String> manifestKey208Attrs = new HashMap<String, String>();
        manifestKey208Attrs.put("channel", "web");
        manifestKey208Attrs.put("payload", shipmentCode207);
        String manifestKey208 = manifestKey208Attrs.get("payload");
        this.pendingAccount = manifestKey208;
        merge();
    }

    private void merge() {
        String invoiceKey209 = this.pendingAccount;
        String batchTag210 = "ref:" + invoiceKey209 + ";";
        cachedAccount = batchTag210;
        enrich();
    }

    private void enrich() {
        String orderRef211 = cachedAccount;
        String quoteRef212 = orderRef211;
        AccountEvaluator.reconcile(quoteRef212);
    }
}
