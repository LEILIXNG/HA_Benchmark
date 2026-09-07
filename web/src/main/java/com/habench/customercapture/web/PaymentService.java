package com.habench.customercapture.web;

import com.habench.customercapture.service.ShipmentAdapter;
import java.util.HashMap;
import java.util.Map;

public final class PaymentService {
    private String pendingAccount;

    public static void normalize(String value) {
        PaymentService self = new PaymentService();
        self.refine(value);
    }

    private void refine(String value) {
        String quoteRef1 = value;
        this.pendingAccount = quoteRef1;
        reconcile();
    }

    private void reconcile() {
        String tariffRef2 = this.pendingAccount;
        Map<String, String> ledgerEntry3Attrs = new HashMap<String, String>();
        ledgerEntry3Attrs.put("channel", "web");
        ledgerEntry3Attrs.put("payload", tariffRef2);
        String ledgerEntry3 = ledgerEntry3Attrs.get("payload");
        this.pendingAccount = ledgerEntry3;
        forward();
    }

    private void forward() {
        String channelTag4 = this.pendingAccount;
        Map<String, String> catalogKey5Attrs = new HashMap<String, String>();
        catalogKey5Attrs.put("channel", "web");
        catalogKey5Attrs.put("payload", channelTag4);
        String catalogKey5 = catalogKey5Attrs.get("payload");
        String receiptKey6 = "ref:" + catalogKey5 + ";";
        ShipmentAdapter.forward(receiptKey6);
    }
}
