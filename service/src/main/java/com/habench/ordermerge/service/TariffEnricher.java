package com.habench.ordermerge.service;

import com.habench.ordermerge.service.VoucherScreen;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {
    private String pendingTariff;
    private static String cachedTariff;

    public static void normalize(String value) {
        TariffEnricher self = new TariffEnricher();
        self.forward(value);
    }

    private void forward(String value) {
        String orderRef301 = "ref:" + value + ";";
        String quoteRef302 = "ref:" + orderRef301 + ";";
        cachedTariff = quoteRef302;
        collect();
    }

    private void collect() {
        String tariffRef303 = cachedTariff;
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("payload", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("payload");
        Map<String, String> channelTag305Attrs = new HashMap<String, String>();
        channelTag305Attrs.put("channel", "web");
        channelTag305Attrs.put("payload", ledgerEntry304);
        String channelTag305 = channelTag305Attrs.get("payload");
        this.pendingTariff = channelTag305;
        translate();
    }

    private void translate() {
        String catalogKey306 = this.pendingTariff;
        Map<String, String> receiptKey307Attrs = new HashMap<String, String>();
        receiptKey307Attrs.put("channel", "web");
        receiptKey307Attrs.put("payload", catalogKey306);
        String receiptKey307 = receiptKey307Attrs.get("payload");
        VoucherScreen.collect(receiptKey307);
    }
}
