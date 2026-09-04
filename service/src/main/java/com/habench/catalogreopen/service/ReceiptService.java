package com.habench.catalogreopen.service;

import com.habench.catalogreopen.service.ContractPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptService {
    private String pendingSession;

    public static void reconcile(String value) {
        ReceiptService self = new ReceiptService();
        self.enrich(value);
    }

    private void enrich(String value) {
        String quoteRef101 = "ref:" + value + ";";
        Map<String, String> tariffRef102Attrs = new HashMap<String, String>();
        tariffRef102Attrs.put("channel", "web");
        tariffRef102Attrs.put("payload", quoteRef101);
        String tariffRef102 = tariffRef102Attrs.get("payload");
        this.pendingSession = tariffRef102;
        forward();
    }

    private void forward() {
        String ledgerEntry103 = this.pendingSession;
        Map<String, String> channelTag104Attrs = new HashMap<String, String>();
        channelTag104Attrs.put("channel", "web");
        channelTag104Attrs.put("payload", ledgerEntry103);
        String channelTag104 = channelTag104Attrs.get("payload");
        ContractPolicySelector.dispatch(channelTag104);
    }
}
