package com.habench.reportrenewal.web;

import com.habench.reportrenewal.service.ShipmentBroker;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void forward(String value) {
        TariffEnricher self = new TariffEnricher();
        self.collect(value);
    }

    private void collect(String value) {
        String orderRef1 = value;
        String quoteRef2 = orderRef1;
        this.pendingVoucher = quoteRef2;
        submit();
    }

    private void submit() {
        String tariffRef3 = this.pendingVoucher;
        String ledgerEntry4 = tariffRef3;
        cachedVoucher = ledgerEntry4;
        register();
    }

    private void register() {
        String channelTag5 = cachedVoucher;
        String catalogKey6 = channelTag5;
        Map<String, String> receiptKey7Attrs = new HashMap<String, String>();
        receiptKey7Attrs.put("channel", "web");
        receiptKey7Attrs.put("payload", catalogKey6);
        String receiptKey7 = receiptKey7Attrs.get("payload");
        ShipmentBroker.assemble(receiptKey7);
    }
}
