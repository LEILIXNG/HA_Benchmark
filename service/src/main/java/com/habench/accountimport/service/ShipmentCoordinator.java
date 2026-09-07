package com.habench.accountimport.service;

import com.habench.accountimport.service.LedgerRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCoordinator {
    private String pendingContract;
    private static String cachedContract;

    public static void collect(String value) {
        ShipmentCoordinator self = new ShipmentCoordinator();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        String accountRef102 = receiptKey101;
        cachedContract = accountRef102;
        assemble();
    }

    private void assemble() {
        String voucherRef103 = cachedContract;
        Map<String, String> paymentTag104Attrs = new HashMap<String, String>();
        paymentTag104Attrs.put("channel", "web");
        paymentTag104Attrs.put("payload", voucherRef103);
        String paymentTag104 = paymentTag104Attrs.get("payload");
        this.pendingContract = paymentTag104;
        publish();
    }

    private void publish() {
        String refundCode105 = this.pendingContract;
        String shipmentCode106 = refundCode105;
        Map<String, String> manifestKey107Attrs = new HashMap<String, String>();
        manifestKey107Attrs.put("channel", "web");
        manifestKey107Attrs.put("payload", shipmentCode106);
        String manifestKey107 = manifestKey107Attrs.get("payload");
        LedgerRuleSelector.dispatch(manifestKey107);
    }
}
