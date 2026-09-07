package com.habench.fulfilreopen.web;

import com.habench.fulfilreopen.service.InvoiceNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceComposer {
    private String pendingRefund;
    private static String cachedRefund;

    public static void publish(String value) {
        InvoiceComposer self = new InvoiceComposer();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> paymentTag101Attrs = new HashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("payload", value);
        String paymentTag101 = paymentTag101Attrs.get("payload");
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("payload", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("payload");
        this.pendingRefund = refundCode102;
        register();
    }

    private void register() {
        String shipmentCode103 = this.pendingRefund;
        Map<String, String> manifestKey104Attrs = new HashMap<String, String>();
        manifestKey104Attrs.put("channel", "web");
        manifestKey104Attrs.put("payload", shipmentCode103);
        String manifestKey104 = manifestKey104Attrs.get("payload");
        String invoiceKey105 = manifestKey104;
        this.pendingRefund = invoiceKey105;
        refine();
    }

    private void refine() {
        String batchTag106 = this.pendingRefund;
        String orderRef107 = "ref:" + batchTag106 + ";";
        cachedRefund = orderRef107;
        expand();
    }

    private void expand() {
        String quoteRef108 = cachedRefund;
        String tariffRef109 = "ref:" + quoteRef108 + ";";
        InvoiceNormalizer.assemble(tariffRef109);
    }
}
