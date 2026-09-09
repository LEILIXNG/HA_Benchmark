package com.habench.catalogposting.web;

import com.habench.catalogposting.web.ReceiptStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffAdapter {
    private String pendingAccount;
    private static String cachedAccount;

    public static void forward(String value) {
        TariffAdapter self = new TariffAdapter();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        this.pendingAccount = shipmentCode1;
        route();
    }

    private void route() {
        String manifestKey2 = this.pendingAccount;
        String invoiceKey3 = "ref:" + manifestKey2 + ";";
        this.pendingAccount = invoiceKey3;
        expand();
    }

    private void expand() {
        String batchTag4 = this.pendingAccount;
        Map<String, String> orderRef5Attrs = new HashMap<String, String>();
        orderRef5Attrs.put("channel", "web");
        orderRef5Attrs.put("payload", batchTag4);
        String orderRef5 = orderRef5Attrs.get("payload");
        cachedAccount = orderRef5;
        dispatch();
    }

    private void dispatch() {
        String quoteRef6 = cachedAccount;
        String tariffRef7 = quoteRef6;
        String ledgerEntry8 = "ref:" + tariffRef7 + ";";
        ReceiptStrategySelector.register(ledgerEntry8);
    }
}
