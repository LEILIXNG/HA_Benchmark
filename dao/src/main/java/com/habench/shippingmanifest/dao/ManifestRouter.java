package com.habench.shippingmanifest.dao;

import com.habench.shippingmanifest.dao.CatalogEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {
    private static String cachedShipment;

    public static void dispatch(String value) {
        String quoteRef301 = "ref:" + value + ";";
        String tariffRef302 = quoteRef301;
        cachedShipment = tariffRef302;
        attach();
    }

    private static void attach() {
        String ledgerEntry303 = cachedShipment;
        String channelTag304 = "ref:" + ledgerEntry303 + ";";
        String catalogKey305 = "ref:" + channelTag304 + ";";
        cachedShipment = catalogKey305;
        route();
    }

    private static void route() {
        String receiptKey306 = cachedShipment;
        String accountRef307 = "ref:" + receiptKey306 + ";";
        Map<String, String> voucherRef308Attrs = new HashMap<String, String>();
        voucherRef308Attrs.put("channel", "web");
        voucherRef308Attrs.put("payload", accountRef307);
        String voucherRef308 = voucherRef308Attrs.get("payload");
        CatalogEnricher.submit(voucherRef308);
    }
}
