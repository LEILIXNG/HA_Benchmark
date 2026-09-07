package com.habench.accountlookup.service;

import com.habench.accountlookup.service.ReceiptEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class OrderEnricher {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void forward(String value) {
        OrderEnricher self = new OrderEnricher();
        self.merge(value);
    }

    private void merge(String value) {
        String invoiceKey201 = value;
        cachedReceipt = invoiceKey201;
        expand();
    }

    private void expand() {
        String batchTag202 = cachedReceipt;
        String orderRef203 = batchTag202;
        cachedReceipt = orderRef203;
        compose();
    }

    private void compose() {
        String quoteRef204 = cachedReceipt;
        Map<String, String> tariffRef205Attrs = new HashMap<String, String>();
        tariffRef205Attrs.put("channel", "web");
        tariffRef205Attrs.put("payload", quoteRef204);
        String tariffRef205 = tariffRef205Attrs.get("payload");
        String ledgerEntry206 = "ref:" + tariffRef205 + ";";
        this.pendingReceipt = ledgerEntry206;
        route();
    }

    private void route() {
        String channelTag207 = this.pendingReceipt;
        String catalogKey208 = channelTag207;
        ReceiptEvaluator.prepare(catalogKey208);
    }
}
