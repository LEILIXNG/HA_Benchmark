package com.habench.vendornotice.web;

import com.habench.vendornotice.web.TariffExecutor;
import java.util.HashMap;
import java.util.Map;

public final class LedgerService {
    private static String cachedTariff;

    public static void prepare(String value) {
        String shipmentCode1 = value;
        String manifestKey2 = shipmentCode1;
        cachedTariff = manifestKey2;
        attach();
    }

    private static void attach() {
        String invoiceKey3 = cachedTariff;
        String batchTag4 = "ref:" + invoiceKey3 + ";";
        Map<String, String> orderRef5Attrs = new HashMap<String, String>();
        orderRef5Attrs.put("channel", "web");
        orderRef5Attrs.put("payload", batchTag4);
        String orderRef5 = orderRef5Attrs.get("payload");
        cachedTariff = orderRef5;
        publish();
    }

    private static void publish() {
        String quoteRef6 = cachedTariff;
        String tariffRef7 = "ref:" + quoteRef6 + ";";
        String ledgerEntry8 = tariffRef7;
        TariffExecutor.compose(ledgerEntry8);
    }
}
