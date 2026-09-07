package com.habench.paymentapprove.web;

import com.habench.paymentapprove.service.TariffCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class CatalogNormalizer {
    private String pendingAccount;

    public static void stage(String value) {
        CatalogNormalizer self = new CatalogNormalizer();
        self.translate(value);
    }

    private void translate(String value) {
        String paymentTag101 = "ref:" + value + ";";
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("payload", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("payload");
        this.pendingAccount = refundCode102;
        expand();
    }

    private void expand() {
        String shipmentCode103 = this.pendingAccount;
        Map<String, String> manifestKey104Attrs = new HashMap<String, String>();
        manifestKey104Attrs.put("channel", "web");
        manifestKey104Attrs.put("payload", shipmentCode103);
        String manifestKey104 = manifestKey104Attrs.get("payload");
        TariffCoordinator.collect(manifestKey104);
    }
}
