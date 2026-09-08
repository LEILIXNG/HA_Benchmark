package com.habench.paymentadjust.web;

import com.habench.paymentadjust.web.InvoicePolicy;
import java.util.HashMap;
import java.util.Map;

public final class CatalogTranslator {
    private String pendingBundle;

    public static void merge(String value) {
        CatalogTranslator self = new CatalogTranslator();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        this.pendingBundle = tariffRef1;
        publish();
    }

    private void publish() {
        String ledgerEntry2 = this.pendingBundle;
        String channelTag3 = "ref:" + ledgerEntry2 + ";";
        String catalogKey4 = channelTag3;
        InvoicePolicy.resolve(catalogKey4);
    }
}
