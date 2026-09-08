package com.habench.fulfilclose.service;

import com.habench.fulfilclose.dao.AccountRouter;
import java.util.HashMap;
import java.util.Map;

public final class SessionCoordinator {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void reconcile(String value) {
        SessionCoordinator self = new SessionCoordinator();
        self.resolve(value);
    }

    private void resolve(String value) {
        String batchTag101 = value;
        this.pendingCatalog = batchTag101;
        collect();
    }

    private void collect() {
        String orderRef102 = this.pendingCatalog;
        String quoteRef103 = "ref:" + orderRef102 + ";";
        cachedCatalog = quoteRef103;
        stage();
    }

    private void stage() {
        String tariffRef104 = cachedCatalog;
        String ledgerEntry105 = "ref:" + tariffRef104 + ";";
        cachedCatalog = ledgerEntry105;
        forward();
    }

    private void forward() {
        String channelTag106 = cachedCatalog;
        Map<String, String> catalogKey107Attrs = new HashMap<String, String>();
        catalogKey107Attrs.put("channel", "web");
        catalogKey107Attrs.put("payload", channelTag106);
        String catalogKey107 = catalogKey107Attrs.get("payload");
        String receiptKey108 = catalogKey107;
        this.pendingCatalog = receiptKey108;
        register();
    }

    private void register() {
        String accountRef109 = this.pendingCatalog;
        Map<String, String> voucherRef110Attrs = new HashMap<String, String>();
        voucherRef110Attrs.put("channel", "web");
        voucherRef110Attrs.put("payload", accountRef109);
        String voucherRef110 = voucherRef110Attrs.get("payload");
        this.pendingCatalog = voucherRef110;
        enrich();
    }

    private void enrich() {
        String paymentTag111 = this.pendingCatalog;
        Map<String, String> refundCode112Attrs = new HashMap<String, String>();
        refundCode112Attrs.put("channel", "web");
        refundCode112Attrs.put("payload", paymentTag111);
        String refundCode112 = refundCode112Attrs.get("payload");
        this.pendingCatalog = refundCode112;
        refine();
    }

    private void refine() {
        String shipmentCode113 = this.pendingCatalog;
        String manifestKey114 = "ref:" + shipmentCode113 + ";";
        AccountRouter.submit(manifestKey114);
    }
}
