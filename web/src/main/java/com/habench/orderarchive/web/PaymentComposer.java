package com.habench.orderarchive.web;

import com.habench.orderarchive.service.ContractTranslator;
import java.util.HashMap;
import java.util.Map;

public final class PaymentComposer {
    private String pendingOrder;
    private static String cachedOrder;

    public static void compose(String value) {
        PaymentComposer self = new PaymentComposer();
        self.translate(value);
    }

    private void translate(String value) {
        String manifestKey1 = "ref:" + value + ";";
        cachedOrder = manifestKey1;
        route();
    }

    private void route() {
        String invoiceKey2 = cachedOrder;
        String batchTag3 = "ref:" + invoiceKey2 + ";";
        this.pendingOrder = batchTag3;
        merge();
    }

    private void merge() {
        String orderRef4 = this.pendingOrder;
        Map<String, String> quoteRef5Attrs = new HashMap<String, String>();
        quoteRef5Attrs.put("channel", "web");
        quoteRef5Attrs.put("payload", orderRef4);
        String quoteRef5 = quoteRef5Attrs.get("payload");
        String tariffRef6 = "ref:" + quoteRef5 + ";";
        ContractTranslator.assemble(tariffRef6);
    }
}
