package com.habench.shippingsettle.web;

import com.habench.shippingsettle.web.ShipmentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherService {
    private String pendingTariff;
    private static String cachedTariff;

    public static void normalize(String value) {
        VoucherService self = new VoucherService();
        self.refine(value);
    }

    private void refine(String value) {
        String tariffRef1 = "ref:" + value + ";";
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("payload", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("payload");
        this.pendingTariff = ledgerEntry2;
        translate();
    }

    private void translate() {
        String channelTag3 = this.pendingTariff;
        String catalogKey4 = "ref:" + channelTag3 + ";";
        String receiptKey5 = catalogKey4;
        cachedTariff = receiptKey5;
        prepare();
    }

    private void prepare() {
        String accountRef6 = cachedTariff;
        String voucherRef7 = accountRef6;
        cachedTariff = voucherRef7;
        merge();
    }

    private void merge() {
        String paymentTag8 = cachedTariff;
        String refundCode9 = paymentTag8;
        Map<String, String> shipmentCode10Attrs = new HashMap<String, String>();
        shipmentCode10Attrs.put("channel", "web");
        shipmentCode10Attrs.put("payload", refundCode9);
        String shipmentCode10 = shipmentCode10Attrs.get("payload");
        ShipmentStrategySelector.route(shipmentCode10);
    }
}
