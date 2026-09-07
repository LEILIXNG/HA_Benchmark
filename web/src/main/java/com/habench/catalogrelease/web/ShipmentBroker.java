package com.habench.catalogrelease.web;

import com.habench.catalogrelease.service.ContractCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker {
    private String pendingInvoice;

    public static void enrich(String value) {
        ShipmentBroker self = new ShipmentBroker();
        self.compose(value);
    }

    private void compose(String value) {
        String tariffRef1 = value;
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("payload", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("payload");
        this.pendingInvoice = ledgerEntry2;
        prepare();
    }

    private void prepare() {
        String channelTag3 = this.pendingInvoice;
        String catalogKey4 = "ref:" + channelTag3 + ";";
        Map<String, String> receiptKey5Attrs = new HashMap<String, String>();
        receiptKey5Attrs.put("channel", "web");
        receiptKey5Attrs.put("payload", catalogKey4);
        String receiptKey5 = receiptKey5Attrs.get("payload");
        ContractCoordinator.translate(receiptKey5);
    }
}
