package com.habench.shippingtransfer.service;

import com.habench.shippingtransfer.service.BundleScreen;
import java.util.HashMap;
import java.util.Map;

public final class CatalogAssembler {
    private String pendingTariff;
    private static String cachedTariff;

    public static void publish(String value) {
        CatalogAssembler self = new CatalogAssembler();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        Map<String, String> paymentTag102Attrs = new HashMap<String, String>();
        paymentTag102Attrs.put("channel", "web");
        paymentTag102Attrs.put("payload", voucherRef101);
        String paymentTag102 = paymentTag102Attrs.get("payload");
        cachedTariff = paymentTag102;
        attach();
    }

    private void attach() {
        String refundCode103 = cachedTariff;
        String shipmentCode104 = "ref:" + refundCode103 + ";";
        this.pendingTariff = shipmentCode104;
        forward();
    }

    private void forward() {
        String manifestKey105 = this.pendingTariff;
        String invoiceKey106 = manifestKey105;
        String batchTag107 = invoiceKey106;
        cachedTariff = batchTag107;
        normalize();
    }

    private void normalize() {
        String orderRef108 = cachedTariff;
        String quoteRef109 = "ref:" + orderRef108 + ";";
        String tariffRef110 = "ref:" + quoteRef109 + ";";
        BundleScreen.forward(tariffRef110);
    }
}
