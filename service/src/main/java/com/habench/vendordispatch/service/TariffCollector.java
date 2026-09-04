package com.habench.vendordispatch.service;

import com.habench.vendordispatch.dao.PaymentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class TariffCollector {
    private String pendingOrder;
    private static String cachedOrder;

    public static void translate(String value) {
        TariffCollector self = new TariffCollector();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        String batchTag202 = "ref:" + invoiceKey201 + ";";
        cachedOrder = batchTag202;
        submit();
    }

    private void submit() {
        String orderRef203 = cachedOrder;
        Map<String, String> quoteRef204Attrs = new HashMap<String, String>();
        quoteRef204Attrs.put("channel", "web");
        quoteRef204Attrs.put("payload", orderRef203);
        String quoteRef204 = quoteRef204Attrs.get("payload");
        String tariffRef205 = "ref:" + quoteRef204 + ";";
        this.pendingOrder = tariffRef205;
        expand();
    }

    private void expand() {
        String ledgerEntry206 = this.pendingOrder;
        String channelTag207 = "ref:" + ledgerEntry206 + ";";
        Map<String, String> catalogKey208Attrs = new HashMap<String, String>();
        catalogKey208Attrs.put("channel", "web");
        catalogKey208Attrs.put("payload", channelTag207);
        String catalogKey208 = catalogKey208Attrs.get("payload");
        PaymentBuilder.reconcile(catalogKey208);
    }
}
