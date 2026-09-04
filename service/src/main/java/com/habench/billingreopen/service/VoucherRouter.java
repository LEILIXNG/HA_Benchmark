package com.habench.billingreopen.service;

import com.habench.billingreopen.dao.QuoteService;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {
    private String pendingLedger;
    private static String cachedLedger;

    public static void forward(String value) {
        VoucherRouter self = new VoucherRouter();
        self.assemble(value);
    }

    private void assemble(String value) {
        String accountRef101 = value;
        cachedLedger = accountRef101;
        register();
    }

    private void register() {
        String voucherRef102 = cachedLedger;
        String paymentTag103 = voucherRef102;
        cachedLedger = paymentTag103;
        compose();
    }

    private void compose() {
        String refundCode104 = cachedLedger;
        Map<String, String> shipmentCode105Attrs = new HashMap<String, String>();
        shipmentCode105Attrs.put("channel", "web");
        shipmentCode105Attrs.put("payload", refundCode104);
        String shipmentCode105 = shipmentCode105Attrs.get("payload");
        String manifestKey106 = "ref:" + shipmentCode105 + ";";
        this.pendingLedger = manifestKey106;
        stage();
    }

    private void stage() {
        String invoiceKey107 = this.pendingLedger;
        Map<String, String> batchTag108Attrs = new HashMap<String, String>();
        batchTag108Attrs.put("channel", "web");
        batchTag108Attrs.put("payload", invoiceKey107);
        String batchTag108 = batchTag108Attrs.get("payload");
        QuoteService.normalize(batchTag108);
    }
}
