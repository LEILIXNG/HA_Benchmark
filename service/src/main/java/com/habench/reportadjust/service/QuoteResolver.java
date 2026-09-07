package com.habench.reportadjust.service;

import com.habench.reportadjust.service.ManifestValidator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteResolver {
    private String pendingInvoice;
    private static String cachedInvoice;

    public static void collect(String value) {
        QuoteResolver self = new QuoteResolver();
        self.publish(value);
    }

    private void publish(String value) {
        String refundCode301 = "ref:" + value + ";";
        this.pendingInvoice = refundCode301;
        dispatch();
    }

    private void dispatch() {
        String shipmentCode302 = this.pendingInvoice;
        String manifestKey303 = shipmentCode302;
        String invoiceKey304 = "ref:" + manifestKey303 + ";";
        cachedInvoice = invoiceKey304;
        compose();
    }

    private void compose() {
        String batchTag305 = cachedInvoice;
        String orderRef306 = batchTag305;
        String quoteRef307 = orderRef306;
        cachedInvoice = quoteRef307;
        register();
    }

    private void register() {
        String tariffRef308 = cachedInvoice;
        String ledgerEntry309 = tariffRef308;
        cachedInvoice = ledgerEntry309;
        translate();
    }

    private void translate() {
        String channelTag310 = cachedInvoice;
        Map<String, String> catalogKey311Attrs = new HashMap<String, String>();
        catalogKey311Attrs.put("channel", "web");
        catalogKey311Attrs.put("payload", channelTag310);
        String catalogKey311 = catalogKey311Attrs.get("payload");
        cachedInvoice = catalogKey311;
        forward();
    }

    private void forward() {
        String receiptKey312 = cachedInvoice;
        String accountRef313 = receiptKey312;
        String voucherRef314 = "ref:" + accountRef313 + ";";
        ManifestValidator.dispatch(voucherRef314);
    }
}
