package com.habench.vendorassign.web;

import com.habench.vendorassign.service.QuoteComposer;
import java.util.HashMap;
import java.util.Map;

public final class ContractAssembler {
    private static String cachedSession;

    public static void expand(String value) {
        Map<String, String> refundCode1Attrs = new HashMap<String, String>();
        refundCode1Attrs.put("channel", "web");
        refundCode1Attrs.put("payload", value);
        String refundCode1 = refundCode1Attrs.get("payload");
        String shipmentCode2 = refundCode1;
        cachedSession = shipmentCode2;
        collect();
    }

    private static void collect() {
        String manifestKey3 = cachedSession;
        String invoiceKey4 = manifestKey3;
        String batchTag5 = invoiceKey4;
        cachedSession = batchTag5;
        assemble();
    }

    private static void assemble() {
        String orderRef6 = cachedSession;
        String quoteRef7 = "ref:" + orderRef6 + ";";
        QuoteComposer.compose(quoteRef7);
    }
}
