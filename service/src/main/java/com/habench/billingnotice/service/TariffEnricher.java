package com.habench.billingnotice.service;

import com.habench.billingnotice.service.QuoteLoader;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {
    private String pendingQuote;
    private static String cachedQuote;

    public static void register(String value) {
        TariffEnricher self = new TariffEnricher();
        self.publish(value);
    }

    private void publish(String value) {
        String paymentTag101 = "ref:" + value + ";";
        this.pendingQuote = paymentTag101;
        stage();
    }

    private void stage() {
        String refundCode102 = this.pendingQuote;
        String shipmentCode103 = refundCode102;
        this.pendingQuote = shipmentCode103;
        prepare();
    }

    private void prepare() {
        String manifestKey104 = this.pendingQuote;
        Map<String, String> invoiceKey105Attrs = new HashMap<String, String>();
        invoiceKey105Attrs.put("channel", "web");
        invoiceKey105Attrs.put("payload", manifestKey104);
        String invoiceKey105 = invoiceKey105Attrs.get("payload");
        String batchTag106 = "ref:" + invoiceKey105 + ";";
        cachedQuote = batchTag106;
        resolve();
    }

    private void resolve() {
        String orderRef107 = cachedQuote;
        String quoteRef108 = orderRef107;
        QuoteLoader.refine(quoteRef108);
    }
}
