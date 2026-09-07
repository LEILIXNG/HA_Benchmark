package com.habench.paymentreview.service;

import com.habench.paymentreview.service.ReceiptPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class LedgerService {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void dispatch(String value) {
        LedgerService self = new LedgerService();
        self.merge(value);
    }

    private void merge(String value) {
        String manifestKey201 = value;
        Map<String, String> invoiceKey202Attrs = new HashMap<String, String>();
        invoiceKey202Attrs.put("channel", "web");
        invoiceKey202Attrs.put("payload", manifestKey201);
        String invoiceKey202 = invoiceKey202Attrs.get("payload");
        this.pendingReceipt = invoiceKey202;
        forward();
    }

    private void forward() {
        String batchTag203 = this.pendingReceipt;
        Map<String, String> orderRef204Attrs = new HashMap<String, String>();
        orderRef204Attrs.put("channel", "web");
        orderRef204Attrs.put("payload", batchTag203);
        String orderRef204 = orderRef204Attrs.get("payload");
        cachedReceipt = orderRef204;
        expand();
    }

    private void expand() {
        String quoteRef205 = cachedReceipt;
        Map<String, String> tariffRef206Attrs = new HashMap<String, String>();
        tariffRef206Attrs.put("channel", "web");
        tariffRef206Attrs.put("payload", quoteRef205);
        String tariffRef206 = tariffRef206Attrs.get("payload");
        String ledgerEntry207 = "ref:" + tariffRef206 + ";";
        cachedReceipt = ledgerEntry207;
        normalize();
    }

    private void normalize() {
        String channelTag208 = cachedReceipt;
        String catalogKey209 = "ref:" + channelTag208 + ";";
        ReceiptPolicySelector.refine(catalogKey209);
    }
}
