package com.habench.vendorposting.web;

import com.habench.vendorposting.service.VoucherAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRegistry {
    private String pendingBundle;
    private static String cachedBundle;

    public static void publish(String value) {
        ManifestRegistry self = new ManifestRegistry();
        self.enrich(value);
    }

    private void enrich(String value) {
        String voucherRef101 = value;
        cachedBundle = voucherRef101;
        compose();
    }

    private void compose() {
        String paymentTag102 = cachedBundle;
        String refundCode103 = paymentTag102;
        cachedBundle = refundCode103;
        register();
    }

    private void register() {
        String shipmentCode104 = cachedBundle;
        String manifestKey105 = shipmentCode104;
        String invoiceKey106 = "ref:" + manifestKey105 + ";";
        cachedBundle = invoiceKey106;
        reconcile();
    }

    private void reconcile() {
        String batchTag107 = cachedBundle;
        Map<String, String> orderRef108Attrs = new HashMap<String, String>();
        orderRef108Attrs.put("channel", "web");
        orderRef108Attrs.put("payload", batchTag107);
        String orderRef108 = orderRef108Attrs.get("payload");
        cachedBundle = orderRef108;
        expand();
    }

    private void expand() {
        String quoteRef109 = cachedBundle;
        String tariffRef110 = quoteRef109;
        this.pendingBundle = tariffRef110;
        resolve();
    }

    private void resolve() {
        String ledgerEntry111 = this.pendingBundle;
        String channelTag112 = "ref:" + ledgerEntry111 + ";";
        VoucherAdapter.assemble(channelTag112);
    }
}
