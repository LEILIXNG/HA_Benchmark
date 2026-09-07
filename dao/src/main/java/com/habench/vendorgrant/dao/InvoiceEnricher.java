package com.habench.vendorgrant.dao;

import com.habench.vendorgrant.dao.RefundPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceEnricher {
    private String pendingOrder;
    private static String cachedOrder;

    public static void merge(String value) {
        InvoiceEnricher self = new InvoiceEnricher();
        self.resolve(value);
    }

    private void resolve(String value) {
        String catalogKey201 = value;
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        cachedOrder = receiptKey202;
        normalize();
    }

    private void normalize() {
        String accountRef203 = cachedOrder;
        Map<String, String> voucherRef204Attrs = new HashMap<String, String>();
        voucherRef204Attrs.put("channel", "web");
        voucherRef204Attrs.put("payload", accountRef203);
        String voucherRef204 = voucherRef204Attrs.get("payload");
        this.pendingOrder = voucherRef204;
        refine();
    }

    private void refine() {
        String paymentTag205 = this.pendingOrder;
        Map<String, String> refundCode206Attrs = new HashMap<String, String>();
        refundCode206Attrs.put("channel", "web");
        refundCode206Attrs.put("payload", paymentTag205);
        String refundCode206 = refundCode206Attrs.get("payload");
        cachedOrder = refundCode206;
        publish();
    }

    private void publish() {
        String shipmentCode207 = cachedOrder;
        Map<String, String> manifestKey208Attrs = new HashMap<String, String>();
        manifestKey208Attrs.put("channel", "web");
        manifestKey208Attrs.put("payload", shipmentCode207);
        String manifestKey208 = manifestKey208Attrs.get("payload");
        cachedOrder = manifestKey208;
        expand();
    }

    private void expand() {
        String invoiceKey209 = cachedOrder;
        Map<String, String> batchTag210Attrs = new HashMap<String, String>();
        batchTag210Attrs.put("channel", "web");
        batchTag210Attrs.put("payload", invoiceKey209);
        String batchTag210 = batchTag210Attrs.get("payload");
        this.pendingOrder = batchTag210;
        stage();
    }

    private void stage() {
        String orderRef211 = this.pendingOrder;
        String quoteRef212 = "ref:" + orderRef211 + ";";
        String tariffRef213 = "ref:" + quoteRef212 + ";";
        RefundPolicySelector.stage(tariffRef213);
    }
}
