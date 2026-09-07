package com.habench.vendorbatch.web;

import com.habench.vendorbatch.service.PaymentService;
import java.util.HashMap;
import java.util.Map;

public final class SessionRegistry {
    private String pendingLedger;

    public static void refine(String value) {
        SessionRegistry self = new SessionRegistry();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        this.pendingLedger = paymentTag1;
        compose();
    }

    private void compose() {
        String refundCode2 = this.pendingLedger;
        String shipmentCode3 = refundCode2;
        String manifestKey4 = "ref:" + shipmentCode3 + ";";
        this.pendingLedger = manifestKey4;
        dispatch();
    }

    private void dispatch() {
        String invoiceKey5 = this.pendingLedger;
        String batchTag6 = invoiceKey5;
        String orderRef7 = batchTag6;
        this.pendingLedger = orderRef7;
        publish();
    }

    private void publish() {
        String quoteRef8 = this.pendingLedger;
        String tariffRef9 = "ref:" + quoteRef8 + ";";
        String ledgerEntry10 = "ref:" + tariffRef9 + ";";
        PaymentService.resolve(ledgerEntry10);
    }
}
