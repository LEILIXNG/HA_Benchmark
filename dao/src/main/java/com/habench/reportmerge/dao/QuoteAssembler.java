package com.habench.reportmerge.dao;

import com.habench.reportmerge.dao.InvoicePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAssembler {
    private String pendingSession;

    public static void route(String value) {
        QuoteAssembler self = new QuoteAssembler();
        self.refine(value);
    }

    private void refine(String value) {
        String batchTag301 = value;
        this.pendingSession = batchTag301;
        collect();
    }

    private void collect() {
        String orderRef302 = this.pendingSession;
        Map<String, String> quoteRef303Attrs = new HashMap<String, String>();
        quoteRef303Attrs.put("channel", "web");
        quoteRef303Attrs.put("payload", orderRef302);
        String quoteRef303 = quoteRef303Attrs.get("payload");
        InvoicePlanSelector.compose(quoteRef303);
    }
}
