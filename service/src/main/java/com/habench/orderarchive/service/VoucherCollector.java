package com.habench.orderarchive.service;

import com.habench.orderarchive.service.QuoteRouter;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCollector {
    private String pendingOrder;
    private static String cachedOrder;

    public static void attach(String value) {
        VoucherCollector self = new VoucherCollector();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        this.pendingOrder = ledgerEntry301;
        merge();
    }

    private void merge() {
        String channelTag302 = this.pendingOrder;
        Map<String, String> catalogKey303Attrs = new HashMap<String, String>();
        catalogKey303Attrs.put("channel", "web");
        catalogKey303Attrs.put("payload", channelTag302);
        String catalogKey303 = catalogKey303Attrs.get("payload");
        cachedOrder = catalogKey303;
        collect();
    }

    private void collect() {
        String receiptKey304 = cachedOrder;
        Map<String, String> accountRef305Attrs = new HashMap<String, String>();
        accountRef305Attrs.put("channel", "web");
        accountRef305Attrs.put("payload", receiptKey304);
        String accountRef305 = accountRef305Attrs.get("payload");
        Map<String, String> voucherRef306Attrs = new HashMap<String, String>();
        voucherRef306Attrs.put("channel", "web");
        voucherRef306Attrs.put("payload", accountRef305);
        String voucherRef306 = voucherRef306Attrs.get("payload");
        cachedOrder = voucherRef306;
        register();
    }

    private void register() {
        String paymentTag307 = cachedOrder;
        String refundCode308 = paymentTag307;
        String shipmentCode309 = refundCode308;
        QuoteRouter.normalize(shipmentCode309);
    }
}
