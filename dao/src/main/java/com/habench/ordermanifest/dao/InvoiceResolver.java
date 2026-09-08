package com.habench.ordermanifest.dao;

import com.habench.ordermanifest.dao.OrderRouter;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void merge(String value) {
        InvoiceResolver self = new InvoiceResolver();
        self.normalize(value);
    }

    private void normalize(String value) {
        String receiptKey401 = value;
        String accountRef402 = "ref:" + receiptKey401 + ";";
        cachedCatalog = accountRef402;
        dispatch();
    }

    private void dispatch() {
        String voucherRef403 = cachedCatalog;
        String paymentTag404 = "ref:" + voucherRef403 + ";";
        cachedCatalog = paymentTag404;
        enrich();
    }

    private void enrich() {
        String refundCode405 = cachedCatalog;
        String shipmentCode406 = refundCode405;
        this.pendingCatalog = shipmentCode406;
        forward();
    }

    private void forward() {
        String manifestKey407 = this.pendingCatalog;
        Map<String, String> invoiceKey408Attrs = new HashMap<String, String>();
        invoiceKey408Attrs.put("channel", "web");
        invoiceKey408Attrs.put("payload", manifestKey407);
        String invoiceKey408 = invoiceKey408Attrs.get("payload");
        Map<String, String> batchTag409Attrs = new HashMap<String, String>();
        batchTag409Attrs.put("channel", "web");
        batchTag409Attrs.put("payload", invoiceKey408);
        String batchTag409 = batchTag409Attrs.get("payload");
        cachedCatalog = batchTag409;
        attach();
    }

    private void attach() {
        String orderRef410 = cachedCatalog;
        String quoteRef411 = "ref:" + orderRef410 + ";";
        Map<String, String> tariffRef412Attrs = new HashMap<String, String>();
        tariffRef412Attrs.put("channel", "web");
        tariffRef412Attrs.put("payload", quoteRef411);
        String tariffRef412 = tariffRef412Attrs.get("payload");
        this.pendingCatalog = tariffRef412;
        compose();
    }

    private void compose() {
        String ledgerEntry413 = this.pendingCatalog;
        String channelTag414 = ledgerEntry413;
        OrderRouter.reconcile(channelTag414);
    }
}
