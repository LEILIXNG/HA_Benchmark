package com.habench.reportapprove.service;

import com.habench.reportapprove.service.QuoteGateway;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {
    private String pendingQuote;

    public static void translate(String value) {
        SessionBuilder self = new SessionBuilder();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        String orderRef202 = "ref:" + batchTag201 + ";";
        this.pendingQuote = orderRef202;
        merge();
    }

    private void merge() {
        String quoteRef203 = this.pendingQuote;
        Map<String, String> tariffRef204Attrs = new HashMap<String, String>();
        tariffRef204Attrs.put("channel", "web");
        tariffRef204Attrs.put("payload", quoteRef203);
        String tariffRef204 = tariffRef204Attrs.get("payload");
        QuoteGateway.resolve(tariffRef204);
    }
}
