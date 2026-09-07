package com.habench.catalogarchive.dao;

import com.habench.catalogarchive.dao.ShipmentExecutor;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {
    private String pendingShipment;
    private static String cachedShipment;

    public static void collect(String value) {
        VoucherRouter self = new VoucherRouter();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("payload", value);
        String invoiceKey301 = invoiceKey301Attrs.get("payload");
        String batchTag302 = invoiceKey301;
        this.pendingShipment = batchTag302;
        expand();
    }

    private void expand() {
        String orderRef303 = this.pendingShipment;
        String quoteRef304 = orderRef303;
        cachedShipment = quoteRef304;
        normalize();
    }

    private void normalize() {
        String tariffRef305 = cachedShipment;
        String ledgerEntry306 = "ref:" + tariffRef305 + ";";
        this.pendingShipment = ledgerEntry306;
        prepare();
    }

    private void prepare() {
        String channelTag307 = this.pendingShipment;
        Map<String, String> catalogKey308Attrs = new HashMap<String, String>();
        catalogKey308Attrs.put("channel", "web");
        catalogKey308Attrs.put("payload", channelTag307);
        String catalogKey308 = catalogKey308Attrs.get("payload");
        ShipmentExecutor.translate(catalogKey308);
    }
}
