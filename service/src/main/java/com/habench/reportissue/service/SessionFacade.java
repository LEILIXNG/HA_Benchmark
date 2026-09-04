package com.habench.reportissue.service;

import com.habench.reportissue.service.CatalogCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class SessionFacade {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void attach(String value) {
        SessionFacade self = new SessionFacade();
        self.enrich(value);
    }

    private void enrich(String value) {
        String channelTag301 = "ref:" + value + ";";
        this.pendingCatalog = channelTag301;
        translate();
    }

    private void translate() {
        String catalogKey302 = this.pendingCatalog;
        String receiptKey303 = catalogKey302;
        String accountRef304 = "ref:" + receiptKey303 + ";";
        cachedCatalog = accountRef304;
        reconcile();
    }

    private void reconcile() {
        String voucherRef305 = cachedCatalog;
        Map<String, String> paymentTag306Attrs = new HashMap<String, String>();
        paymentTag306Attrs.put("channel", "web");
        paymentTag306Attrs.put("payload", voucherRef305);
        String paymentTag306 = paymentTag306Attrs.get("payload");
        String refundCode307 = paymentTag306;
        CatalogCoordinator.merge(refundCode307);
    }
}
