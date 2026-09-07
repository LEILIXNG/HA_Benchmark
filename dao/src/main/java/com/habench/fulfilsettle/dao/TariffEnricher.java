package com.habench.fulfilsettle.dao;

import com.habench.fulfilsettle.dao.VoucherResolver;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void enrich(String value) {
        TariffEnricher self = new TariffEnricher();
        self.publish(value);
    }

    private void publish(String value) {
        String accountRef201 = "ref:" + value + ";";
        String voucherRef202 = accountRef201;
        this.pendingCatalog = voucherRef202;
        expand();
    }

    private void expand() {
        String paymentTag203 = this.pendingCatalog;
        Map<String, String> refundCode204Attrs = new HashMap<String, String>();
        refundCode204Attrs.put("channel", "web");
        refundCode204Attrs.put("payload", paymentTag203);
        String refundCode204 = refundCode204Attrs.get("payload");
        cachedCatalog = refundCode204;
        assemble();
    }

    private void assemble() {
        String shipmentCode205 = cachedCatalog;
        Map<String, String> manifestKey206Attrs = new HashMap<String, String>();
        manifestKey206Attrs.put("channel", "web");
        manifestKey206Attrs.put("payload", shipmentCode205);
        String manifestKey206 = manifestKey206Attrs.get("payload");
        VoucherResolver.resolve(manifestKey206);
    }
}
