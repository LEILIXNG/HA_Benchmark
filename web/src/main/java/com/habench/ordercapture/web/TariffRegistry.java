package com.habench.ordercapture.web;

import com.habench.ordercapture.service.ReceiptEnricher;
import java.util.HashMap;
import java.util.Map;

public final class TariffRegistry {
    private static String cachedChannel;

    public static void resolve(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        String catalogKey2 = "ref:" + channelTag1 + ";";
        cachedChannel = catalogKey2;
        submit();
    }

    private static void submit() {
        String receiptKey3 = cachedChannel;
        Map<String, String> accountRef4Attrs = new HashMap<String, String>();
        accountRef4Attrs.put("channel", "web");
        accountRef4Attrs.put("payload", receiptKey3);
        String accountRef4 = accountRef4Attrs.get("payload");
        Map<String, String> voucherRef5Attrs = new HashMap<String, String>();
        voucherRef5Attrs.put("channel", "web");
        voucherRef5Attrs.put("payload", accountRef4);
        String voucherRef5 = voucherRef5Attrs.get("payload");
        ReceiptEnricher.publish(voucherRef5);
    }
}
