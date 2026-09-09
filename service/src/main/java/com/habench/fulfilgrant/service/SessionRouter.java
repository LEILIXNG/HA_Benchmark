package com.habench.fulfilgrant.service;

import com.habench.fulfilgrant.service.ChannelRegistry;
import java.util.HashMap;
import java.util.Map;

public final class SessionRouter {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void expand(String value) {
        SessionRouter self = new SessionRouter();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> accountRef101Attrs = new HashMap<String, String>();
        accountRef101Attrs.put("channel", "web");
        accountRef101Attrs.put("payload", value);
        String accountRef101 = accountRef101Attrs.get("payload");
        this.pendingReceipt = accountRef101;
        prepare();
    }

    private void prepare() {
        String voucherRef102 = this.pendingReceipt;
        String paymentTag103 = "ref:" + voucherRef102 + ";";
        this.pendingReceipt = paymentTag103;
        register();
    }

    private void register() {
        String refundCode104 = this.pendingReceipt;
        String shipmentCode105 = refundCode104;
        cachedReceipt = shipmentCode105;
        translate();
    }

    private void translate() {
        String manifestKey106 = cachedReceipt;
        String invoiceKey107 = manifestKey106;
        String batchTag108 = invoiceKey107;
        ChannelRegistry.enrich(batchTag108);
    }
}
