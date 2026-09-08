package com.habench.shippingimport.service;

import com.habench.shippingimport.service.VoucherGuard;
import java.util.HashMap;
import java.util.Map;

public final class RefundBroker {
    private String pendingCatalog;

    public static void route(String value) {
        RefundBroker self = new RefundBroker();
        self.publish(value);
    }

    private void publish(String value) {
        String channelTag101 = value;
        Map<String, String> catalogKey102Attrs = new HashMap<String, String>();
        catalogKey102Attrs.put("channel", "web");
        catalogKey102Attrs.put("payload", channelTag101);
        String catalogKey102 = catalogKey102Attrs.get("payload");
        this.pendingCatalog = catalogKey102;
        assemble();
    }

    private void assemble() {
        String receiptKey103 = this.pendingCatalog;
        String accountRef104 = "ref:" + receiptKey103 + ";";
        Map<String, String> voucherRef105Attrs = new HashMap<String, String>();
        voucherRef105Attrs.put("channel", "web");
        voucherRef105Attrs.put("payload", accountRef104);
        String voucherRef105 = voucherRef105Attrs.get("payload");
        VoucherGuard.stage(voucherRef105);
    }
}
