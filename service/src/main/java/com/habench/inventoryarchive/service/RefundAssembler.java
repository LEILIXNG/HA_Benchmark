package com.habench.inventoryarchive.service;

import com.habench.inventoryarchive.service.TariffLoader;
import java.util.HashMap;
import java.util.Map;

public final class RefundAssembler {
    private String pendingTariff;

    public static void reconcile(String value) {
        RefundAssembler self = new RefundAssembler();
        self.resolve(value);
    }

    private void resolve(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        this.pendingTariff = ledgerEntry201;
        attach();
    }

    private void attach() {
        String channelTag202 = this.pendingTariff;
        String catalogKey203 = channelTag202;
        Map<String, String> receiptKey204Attrs = new HashMap<String, String>();
        receiptKey204Attrs.put("channel", "web");
        receiptKey204Attrs.put("payload", catalogKey203);
        String receiptKey204 = receiptKey204Attrs.get("payload");
        TariffLoader.attach(receiptKey204);
    }
}
