package com.habench.catalogrevise.service;

import com.habench.catalogrevise.service.TariffValidator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteResolver {
    private String pendingInvoice;

    public static void publish(String value) {
        QuoteResolver self = new QuoteResolver();
        self.assemble(value);
    }

    private void assemble(String value) {
        String batchTag201 = "ref:" + value + ";";
        Map<String, String> orderRef202Attrs = new HashMap<String, String>();
        orderRef202Attrs.put("channel", "web");
        orderRef202Attrs.put("payload", batchTag201);
        String orderRef202 = orderRef202Attrs.get("payload");
        this.pendingInvoice = orderRef202;
        refine();
    }

    private void refine() {
        String quoteRef203 = this.pendingInvoice;
        Map<String, String> tariffRef204Attrs = new HashMap<String, String>();
        tariffRef204Attrs.put("channel", "web");
        tariffRef204Attrs.put("payload", quoteRef203);
        String tariffRef204 = tariffRef204Attrs.get("payload");
        TariffValidator.submit(tariffRef204);
    }
}
