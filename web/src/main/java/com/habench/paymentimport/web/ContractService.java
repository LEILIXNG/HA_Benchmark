package com.habench.paymentimport.web;

import com.habench.paymentimport.service.ContractNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ContractService {
    private String pendingLedger;

    public static void reconcile(String value) {
        ContractService self = new ContractService();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        String ledgerEntry2 = tariffRef1;
        this.pendingLedger = ledgerEntry2;
        translate();
    }

    private void translate() {
        String channelTag3 = this.pendingLedger;
        Map<String, String> catalogKey4Attrs = new HashMap<String, String>();
        catalogKey4Attrs.put("channel", "web");
        catalogKey4Attrs.put("payload", channelTag3);
        String catalogKey4 = catalogKey4Attrs.get("payload");
        ContractNormalizer.reconcile(catalogKey4);
    }
}
