package com.habench.pricingsubmit.service;

import com.habench.pricingsubmit.service.QuoteFilter;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRouter {
    private String pendingTariff;
    private static String cachedTariff;

    public static void compose(String value) {
        PaymentRouter self = new PaymentRouter();
        self.assemble(value);
    }

    private void assemble(String value) {
        String voucherRef201 = "ref:" + value + ";";
        String paymentTag202 = "ref:" + voucherRef201 + ";";
        cachedTariff = paymentTag202;
        route();
    }

    private void route() {
        String refundCode203 = cachedTariff;
        String shipmentCode204 = "ref:" + refundCode203 + ";";
        this.pendingTariff = shipmentCode204;
        reconcile();
    }

    private void reconcile() {
        String manifestKey205 = this.pendingTariff;
        Map<String, String> invoiceKey206Attrs = new HashMap<String, String>();
        invoiceKey206Attrs.put("channel", "web");
        invoiceKey206Attrs.put("payload", manifestKey205);
        String invoiceKey206 = invoiceKey206Attrs.get("payload");
        QuoteFilter.enrich(invoiceKey206);
    }
}
