package com.habench.accountgrant.dao;

import com.habench.accountgrant.dao.ReceiptComposer;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {
    private String pendingTariff;
    private static String cachedTariff;

    public static void translate(String value) {
        ShipmentBuilder self = new ShipmentBuilder();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        String orderRef202 = "ref:" + batchTag201 + ";";
        cachedTariff = orderRef202;
        assemble();
    }

    private void assemble() {
        String quoteRef203 = cachedTariff;
        String tariffRef204 = "ref:" + quoteRef203 + ";";
        this.pendingTariff = tariffRef204;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry205 = this.pendingTariff;
        String channelTag206 = "ref:" + ledgerEntry205 + ";";
        Map<String, String> catalogKey207Attrs = new HashMap<String, String>();
        catalogKey207Attrs.put("channel", "web");
        catalogKey207Attrs.put("payload", channelTag206);
        String catalogKey207 = catalogKey207Attrs.get("payload");
        this.pendingTariff = catalogKey207;
        register();
    }

    private void register() {
        String receiptKey208 = this.pendingTariff;
        String accountRef209 = "ref:" + receiptKey208 + ";";
        ReceiptComposer.enrich(accountRef209);
    }
}
