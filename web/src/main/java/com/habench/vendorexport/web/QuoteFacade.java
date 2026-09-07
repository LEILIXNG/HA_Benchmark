package com.habench.vendorexport.web;

import com.habench.vendorexport.web.ShipmentPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteFacade {
    private static String cachedBundle;

    public static void submit(String value) {
        String channelTag1 = value;
        String catalogKey2 = channelTag1;
        cachedBundle = catalogKey2;
        prepare();
    }

    private static void prepare() {
        String receiptKey3 = cachedBundle;
        String accountRef4 = "ref:" + receiptKey3 + ";";
        Map<String, String> voucherRef5Attrs = new HashMap<String, String>();
        voucherRef5Attrs.put("channel", "web");
        voucherRef5Attrs.put("payload", accountRef4);
        String voucherRef5 = voucherRef5Attrs.get("payload");
        ShipmentPlanSelector.expand(voucherRef5);
    }
}
