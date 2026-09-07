package com.habench.customerrenewal.service;

import com.habench.customerrenewal.service.QuoteLoader;
import java.util.HashMap;
import java.util.Map;

public final class ContractComposer {
    private String pendingQuote;

    public static void dispatch(String value) {
        ContractComposer self = new ContractComposer();
        self.translate(value);
    }

    private void translate(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        Map<String, String> manifestKey102Attrs = new HashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("payload", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get("payload");
        this.pendingQuote = manifestKey102;
        merge();
    }

    private void merge() {
        String invoiceKey103 = this.pendingQuote;
        String batchTag104 = invoiceKey103;
        QuoteLoader.route(batchTag104);
    }
}
