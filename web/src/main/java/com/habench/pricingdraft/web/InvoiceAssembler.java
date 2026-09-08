package com.habench.pricingdraft.web;

import com.habench.pricingdraft.web.SessionStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAssembler {
    private String pendingChannel;

    public static void dispatch(String value) {
        InvoiceAssembler self = new InvoiceAssembler();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        this.pendingChannel = tariffRef1;
        stage();
    }

    private void stage() {
        String ledgerEntry2 = this.pendingChannel;
        String channelTag3 = ledgerEntry2;
        String catalogKey4 = channelTag3;
        SessionStrategySelector.forward(catalogKey4);
    }
}
