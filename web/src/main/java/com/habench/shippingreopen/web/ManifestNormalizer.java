package com.habench.shippingreopen.web;

import com.habench.shippingreopen.web.ShipmentPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestNormalizer {
    private String pendingQuote;

    public static void enrich(String value) {
        ManifestNormalizer self = new ManifestNormalizer();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String tariffRef101 = value;
        this.pendingQuote = tariffRef101;
        translate();
    }

    private void translate() {
        String ledgerEntry102 = this.pendingQuote;
        String channelTag103 = "ref:" + ledgerEntry102 + ";";
        Map<String, String> catalogKey104Attrs = new HashMap<String, String>();
        catalogKey104Attrs.put("channel", "web");
        catalogKey104Attrs.put("payload", channelTag103);
        String catalogKey104 = catalogKey104Attrs.get("payload");
        ShipmentPolicySelector.assemble(catalogKey104);
    }
}
