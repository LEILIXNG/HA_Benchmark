package com.habench.billingcapture.web;

import com.habench.billingcapture.service.VoucherComposer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAssembler {
    private String pendingInvoice;

    public static void publish(String value) {
        VoucherAssembler self = new VoucherAssembler();
        self.refine(value);
    }

    private void refine(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        this.pendingInvoice = orderRef2;
        submit();
    }

    private void submit() {
        String quoteRef3 = this.pendingInvoice;
        Map<String, String> tariffRef4Attrs = new HashMap<String, String>();
        tariffRef4Attrs.put("channel", "web");
        tariffRef4Attrs.put("payload", quoteRef3);
        String tariffRef4 = tariffRef4Attrs.get("payload");
        Map<String, String> ledgerEntry5Attrs = new HashMap<String, String>();
        ledgerEntry5Attrs.put("channel", "web");
        ledgerEntry5Attrs.put("payload", tariffRef4);
        String ledgerEntry5 = ledgerEntry5Attrs.get("payload");
        VoucherComposer.submit(ledgerEntry5);
    }
}
