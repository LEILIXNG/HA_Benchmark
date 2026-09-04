package com.habench.billingreopen.web;

import com.habench.billingreopen.service.VoucherRouter;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentAdapter {
    private String pendingLedger;
    private static String cachedLedger;

    public static void submit(String value) {
        ShipmentAdapter self = new ShipmentAdapter();
        self.resolve(value);
    }

    private void resolve(String value) {
        String manifestKey1 = "ref:" + value + ";";
        cachedLedger = manifestKey1;
        enrich();
    }

    private void enrich() {
        String invoiceKey2 = cachedLedger;
        Map<String, String> batchTag3Attrs = new HashMap<String, String>();
        batchTag3Attrs.put("channel", "web");
        batchTag3Attrs.put("payload", invoiceKey2);
        String batchTag3 = batchTag3Attrs.get("payload");
        String orderRef4 = batchTag3;
        this.pendingLedger = orderRef4;
        stage();
    }

    private void stage() {
        String quoteRef5 = this.pendingLedger;
        Map<String, String> tariffRef6Attrs = new HashMap<String, String>();
        tariffRef6Attrs.put("channel", "web");
        tariffRef6Attrs.put("payload", quoteRef5);
        String tariffRef6 = tariffRef6Attrs.get("payload");
        VoucherRouter.forward(tariffRef6);
    }
}
