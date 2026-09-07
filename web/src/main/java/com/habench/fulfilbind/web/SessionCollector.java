package com.habench.fulfilbind.web;

import com.habench.fulfilbind.web.OrderRouter;
import java.util.HashMap;
import java.util.Map;

public final class SessionCollector {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void collect(String value) {
        SessionCollector self = new SessionCollector();
        self.translate(value);
    }

    private void translate(String value) {
        String orderRef1 = "ref:" + value + ";";
        this.pendingCatalog = orderRef1;
        merge();
    }

    private void merge() {
        String quoteRef2 = this.pendingCatalog;
        String tariffRef3 = quoteRef2;
        cachedCatalog = tariffRef3;
        submit();
    }

    private void submit() {
        String ledgerEntry4 = cachedCatalog;
        Map<String, String> channelTag5Attrs = new HashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("payload", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get("payload");
        this.pendingCatalog = channelTag5;
        prepare();
    }

    private void prepare() {
        String catalogKey6 = this.pendingCatalog;
        String receiptKey7 = catalogKey6;
        cachedCatalog = receiptKey7;
        normalize();
    }

    private void normalize() {
        String accountRef8 = cachedCatalog;
        String voucherRef9 = "ref:" + accountRef8 + ";";
        cachedCatalog = voucherRef9;
        stage();
    }

    private void stage() {
        String paymentTag10 = cachedCatalog;
        String refundCode11 = "ref:" + paymentTag10 + ";";
        Map<String, String> shipmentCode12Attrs = new HashMap<String, String>();
        shipmentCode12Attrs.put("channel", "web");
        shipmentCode12Attrs.put("payload", refundCode11);
        String shipmentCode12 = shipmentCode12Attrs.get("payload");
        cachedCatalog = shipmentCode12;
        attach();
    }

    private void attach() {
        String manifestKey13 = cachedCatalog;
        String invoiceKey14 = manifestKey13;
        String batchTag15 = invoiceKey14;
        cachedCatalog = batchTag15;
        route();
    }

    private void route() {
        String orderRef16 = cachedCatalog;
        String quoteRef17 = orderRef16;
        this.pendingCatalog = quoteRef17;
        publish();
    }

    private void publish() {
        String tariffRef18 = this.pendingCatalog;
        Map<String, String> ledgerEntry19Attrs = new HashMap<String, String>();
        ledgerEntry19Attrs.put("channel", "web");
        ledgerEntry19Attrs.put("payload", tariffRef18);
        String ledgerEntry19 = ledgerEntry19Attrs.get("payload");
        OrderRouter.forward(ledgerEntry19);
    }
}
