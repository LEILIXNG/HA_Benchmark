package com.habench.inventoryapprove.web;

import com.habench.inventoryapprove.service.AccountAdapter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCoordinator {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void translate(String value) {
        CatalogCoordinator self = new CatalogCoordinator();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        cachedCatalog = refundCode101;
        register();
    }

    private void register() {
        String shipmentCode102 = cachedCatalog;
        String manifestKey103 = "ref:" + shipmentCode102 + ";";
        cachedCatalog = manifestKey103;
        reconcile();
    }

    private void reconcile() {
        String invoiceKey104 = cachedCatalog;
        String batchTag105 = invoiceKey104;
        this.pendingCatalog = batchTag105;
        submit();
    }

    private void submit() {
        String orderRef106 = this.pendingCatalog;
        String quoteRef107 = orderRef106;
        String tariffRef108 = quoteRef107;
        cachedCatalog = tariffRef108;
        stage();
    }

    private void stage() {
        String ledgerEntry109 = cachedCatalog;
        String channelTag110 = ledgerEntry109;
        String catalogKey111 = "ref:" + channelTag110 + ";";
        this.pendingCatalog = catalogKey111;
        enrich();
    }

    private void enrich() {
        String receiptKey112 = this.pendingCatalog;
        String accountRef113 = "ref:" + receiptKey112 + ";";
        this.pendingCatalog = accountRef113;
        route();
    }

    private void route() {
        String voucherRef114 = this.pendingCatalog;
        String paymentTag115 = "ref:" + voucherRef114 + ";";
        String refundCode116 = paymentTag115;
        AccountAdapter.expand(refundCode116);
    }
}
