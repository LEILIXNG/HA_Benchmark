package com.habench.pricingposting.dao;

import com.habench.pricingposting.dao.QuoteLoader;
import java.util.HashMap;
import java.util.Map;

public final class CatalogAssembler {
    private String pendingQuote;

    public static void dispatch(String value) {
        CatalogAssembler self = new CatalogAssembler();
        self.merge(value);
    }

    private void merge(String value) {
        String batchTag301 = "ref:" + value + ";";
        this.pendingQuote = batchTag301;
        register();
    }

    private void register() {
        String orderRef302 = this.pendingQuote;
        String quoteRef303 = orderRef302;
        Map<String, String> tariffRef304Attrs = new HashMap<String, String>();
        tariffRef304Attrs.put("channel", "web");
        tariffRef304Attrs.put("payload", quoteRef303);
        String tariffRef304 = tariffRef304Attrs.get("payload");
        QuoteLoader.assemble(tariffRef304);
    }
}
