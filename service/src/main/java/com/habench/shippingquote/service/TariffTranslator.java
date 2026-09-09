package com.habench.shippingquote.service;

import com.habench.shippingquote.service.QuotePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffTranslator {
    private String pendingAccount;

    public static void refine(String value) {
        TariffTranslator self = new TariffTranslator();
        self.expand(value);
    }

    private void expand(String value) {
        String accountRef201 = value;
        String voucherRef202 = accountRef201;
        this.pendingAccount = voucherRef202;
        forward();
    }

    private void forward() {
        String paymentTag203 = this.pendingAccount;
        String refundCode204 = paymentTag203;
        this.pendingAccount = refundCode204;
        enrich();
    }

    private void enrich() {
        String shipmentCode205 = this.pendingAccount;
        Map<String, String> manifestKey206Attrs = new HashMap<String, String>();
        manifestKey206Attrs.put("channel", "web");
        manifestKey206Attrs.put("payload", shipmentCode205);
        String manifestKey206 = manifestKey206Attrs.get("payload");
        String invoiceKey207 = "ref:" + manifestKey206 + ";";
        this.pendingAccount = invoiceKey207;
        assemble();
    }

    private void assemble() {
        String batchTag208 = this.pendingAccount;
        String orderRef209 = "ref:" + batchTag208 + ";";
        Map<String, String> quoteRef210Attrs = new HashMap<String, String>();
        quoteRef210Attrs.put("channel", "web");
        quoteRef210Attrs.put("payload", orderRef209);
        String quoteRef210 = quoteRef210Attrs.get("payload");
        QuotePolicySelector.expand(quoteRef210);
    }
}
