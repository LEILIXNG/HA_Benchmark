package com.habench.accountrefund.dao;

import com.habench.accountrefund.dao.ContractPolicy;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAssembler {
    private String pendingOrder;

    public static void enrich(String value) {
        ManifestAssembler self = new ManifestAssembler();
        self.refine(value);
    }

    private void refine(String value) {
        String orderRef301 = "ref:" + value + ";";
        this.pendingOrder = orderRef301;
        route();
    }

    private void route() {
        String quoteRef302 = this.pendingOrder;
        Map<String, String> tariffRef303Attrs = new HashMap<String, String>();
        tariffRef303Attrs.put("channel", "web");
        tariffRef303Attrs.put("payload", quoteRef302);
        String tariffRef303 = tariffRef303Attrs.get("payload");
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("payload", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("payload");
        ContractPolicy.publish(ledgerEntry304);
    }
}
