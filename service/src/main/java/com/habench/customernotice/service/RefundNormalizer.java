package com.habench.customernotice.service;

import com.habench.customernotice.dao.BundleAdapter;
import java.util.HashMap;
import java.util.Map;

public final class RefundNormalizer {
    private String pendingRefund;
    private static String cachedRefund;

    public static void attach(String value) {
        RefundNormalizer self = new RefundNormalizer();
        self.publish(value);
    }

    private void publish(String value) {
        String catalogKey201 = value;
        String receiptKey202 = catalogKey201;
        cachedRefund = receiptKey202;
        submit();
    }

    private void submit() {
        String accountRef203 = cachedRefund;
        String voucherRef204 = "ref:" + accountRef203 + ";";
        String paymentTag205 = "ref:" + voucherRef204 + ";";
        cachedRefund = paymentTag205;
        enrich();
    }

    private void enrich() {
        String refundCode206 = cachedRefund;
        String shipmentCode207 = refundCode206;
        String manifestKey208 = "ref:" + shipmentCode207 + ";";
        cachedRefund = manifestKey208;
        translate();
    }

    private void translate() {
        String invoiceKey209 = cachedRefund;
        Map<String, String> batchTag210Attrs = new HashMap<String, String>();
        batchTag210Attrs.put("channel", "web");
        batchTag210Attrs.put("payload", invoiceKey209);
        String batchTag210 = batchTag210Attrs.get("payload");
        String orderRef211 = "ref:" + batchTag210 + ";";
        this.pendingRefund = orderRef211;
        merge();
    }

    private void merge() {
        String quoteRef212 = this.pendingRefund;
        String tariffRef213 = quoteRef212;
        String ledgerEntry214 = tariffRef213;
        BundleAdapter.assemble(ledgerEntry214);
    }
}
