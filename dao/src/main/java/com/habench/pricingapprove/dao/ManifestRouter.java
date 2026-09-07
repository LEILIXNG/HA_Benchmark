package com.habench.pricingapprove.dao;

import com.habench.pricingapprove.dao.InvoiceValidator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void publish(String value) {
        ManifestRouter self = new ManifestRouter();
        self.forward(value);
    }

    private void forward(String value) {
        String receiptKey301 = value;
        String accountRef302 = receiptKey301;
        cachedCatalog = accountRef302;
        translate();
    }

    private void translate() {
        String voucherRef303 = cachedCatalog;
        Map<String, String> paymentTag304Attrs = new HashMap<String, String>();
        paymentTag304Attrs.put("channel", "web");
        paymentTag304Attrs.put("payload", voucherRef303);
        String paymentTag304 = paymentTag304Attrs.get("payload");
        this.pendingCatalog = paymentTag304;
        normalize();
    }

    private void normalize() {
        String refundCode305 = this.pendingCatalog;
        String shipmentCode306 = "ref:" + refundCode305 + ";";
        InvoiceValidator.submit(shipmentCode306);
    }
}
