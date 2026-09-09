package com.habench.reportverify.service;

import com.habench.reportverify.service.AccountGateway;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAdapter {
    private static String cachedAccount;

    public static void submit(String value) {
        Map<String, String> shipmentCode301Attrs = new HashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("payload", value);
        String shipmentCode301 = shipmentCode301Attrs.get("payload");
        cachedAccount = shipmentCode301;
        assemble();
    }

    private static void assemble() {
        String manifestKey302 = cachedAccount;
        String invoiceKey303 = "ref:" + manifestKey302 + ";";
        cachedAccount = invoiceKey303;
        resolve();
    }

    private static void resolve() {
        String batchTag304 = cachedAccount;
        String orderRef305 = "ref:" + batchTag304 + ";";
        String quoteRef306 = orderRef305;
        cachedAccount = quoteRef306;
        register();
    }

    private static void register() {
        String tariffRef307 = cachedAccount;
        Map<String, String> ledgerEntry308Attrs = new HashMap<String, String>();
        ledgerEntry308Attrs.put("channel", "web");
        ledgerEntry308Attrs.put("payload", tariffRef307);
        String ledgerEntry308 = ledgerEntry308Attrs.get("payload");
        String channelTag309 = ledgerEntry308;
        AccountGateway.attach(channelTag309);
    }
}
