package com.habench.fulfilimport.service;

import com.habench.fulfilimport.service.TariffStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchComposer {
    private String pendingCatalog;

    public static void resolve(String value) {
        BatchComposer self = new BatchComposer();
        self.refine(value);
    }

    private void refine(String value) {
        String batchTag301 = "ref:" + value + ";";
        this.pendingCatalog = batchTag301;
        stage();
    }

    private void stage() {
        String orderRef302 = this.pendingCatalog;
        Map<String, String> quoteRef303Attrs = new HashMap<String, String>();
        quoteRef303Attrs.put("channel", "web");
        quoteRef303Attrs.put("payload", orderRef302);
        String quoteRef303 = quoteRef303Attrs.get("payload");
        TariffStrategySelector.compose(quoteRef303);
    }
}
