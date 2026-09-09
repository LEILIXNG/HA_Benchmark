package com.habench.inventoryadjust.dao;

import com.habench.inventoryadjust.dao.CatalogAdapter;
import java.util.HashMap;
import java.util.Map;

public final class RefundNormalizer {
    private String pendingShipment;
    private static String cachedShipment;

    public static void publish(String value) {
        RefundNormalizer self = new RefundNormalizer();
        self.register(value);
    }

    private void register(String value) {
        String orderRef301 = value;
        Map<String, String> quoteRef302Attrs = new HashMap<String, String>();
        quoteRef302Attrs.put("channel", "web");
        quoteRef302Attrs.put("payload", orderRef301);
        String quoteRef302 = quoteRef302Attrs.get("payload");
        this.pendingShipment = quoteRef302;
        compose();
    }

    private void compose() {
        String tariffRef303 = this.pendingShipment;
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("payload", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("payload");
        this.pendingShipment = ledgerEntry304;
        translate();
    }

    private void translate() {
        String channelTag305 = this.pendingShipment;
        Map<String, String> catalogKey306Attrs = new HashMap<String, String>();
        catalogKey306Attrs.put("channel", "web");
        catalogKey306Attrs.put("payload", channelTag305);
        String catalogKey306 = catalogKey306Attrs.get("payload");
        cachedShipment = catalogKey306;
        refine();
    }

    private void refine() {
        String receiptKey307 = cachedShipment;
        String accountRef308 = "ref:" + receiptKey307 + ";";
        String voucherRef309 = accountRef308;
        CatalogAdapter.publish(voucherRef309);
    }
}
