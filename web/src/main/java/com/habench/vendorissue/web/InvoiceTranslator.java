package com.habench.vendorissue.web;

import com.habench.vendorissue.service.TariffNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceTranslator {
    private String pendingPayment;

    public static void expand(String value) {
        InvoiceTranslator self = new InvoiceTranslator();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        this.pendingPayment = batchTag201;
        refine();
    }

    private void refine() {
        String orderRef202 = this.pendingPayment;
        Map<String, String> quoteRef203Attrs = new HashMap<String, String>();
        quoteRef203Attrs.put("channel", "web");
        quoteRef203Attrs.put("payload", orderRef202);
        String quoteRef203 = quoteRef203Attrs.get("payload");
        String tariffRef204 = "ref:" + quoteRef203 + ";";
        TariffNormalizer.compose(tariffRef204);
    }
}
