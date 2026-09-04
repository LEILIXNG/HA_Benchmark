package com.habench.billingreview.web;

import com.habench.billingreview.service.ChannelAssembler;
import java.util.HashMap;
import java.util.Map;

public final class CatalogNormalizer {
    private static String cachedManifest;

    public static void expand(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = "ref:" + orderRef1 + ";";
        cachedManifest = quoteRef2;
        prepare();
    }

    private static void prepare() {
        String tariffRef3 = cachedManifest;
        String ledgerEntry4 = "ref:" + tariffRef3 + ";";
        String channelTag5 = "ref:" + ledgerEntry4 + ";";
        cachedManifest = channelTag5;
        stage();
    }

    private static void stage() {
        String catalogKey6 = cachedManifest;
        String receiptKey7 = catalogKey6;
        String accountRef8 = receiptKey7;
        ChannelAssembler.refine(accountRef8);
    }
}
