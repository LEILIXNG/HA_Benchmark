package com.habench.fulfilmerge.web;

import com.habench.fulfilmerge.web.TariffFacade;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBuilder {
    private static String cachedInvoice;

    public static void resolve(String value) {
        String quoteRef1 = "ref:" + value + ";";
        cachedInvoice = quoteRef1;
        register();
    }

    private static void register() {
        String tariffRef2 = cachedInvoice;
        Map<String, String> ledgerEntry3Attrs = new HashMap<String, String>();
        ledgerEntry3Attrs.put("channel", "web");
        ledgerEntry3Attrs.put("payload", tariffRef2);
        String ledgerEntry3 = ledgerEntry3Attrs.get("payload");
        String channelTag4 = "ref:" + ledgerEntry3 + ";";
        TariffFacade.dispatch(channelTag4);
    }
}
