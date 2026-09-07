package com.habench.catalogsplit.dao;

import com.habench.catalogsplit.dao.ShipmentRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {
    private String pendingAccount;
    private static String cachedAccount;

    public static void merge(String value) {
        ManifestRouter self = new ManifestRouter();
        self.enrich(value);
    }

    private void enrich(String value) {
        String quoteRef401 = "ref:" + value + ";";
        String tariffRef402 = "ref:" + quoteRef401 + ";";
        cachedAccount = tariffRef402;
        submit();
    }

    private void submit() {
        String ledgerEntry403 = cachedAccount;
        String channelTag404 = "ref:" + ledgerEntry403 + ";";
        Map<String, String> catalogKey405Attrs = new HashMap<String, String>();
        catalogKey405Attrs.put("channel", "web");
        catalogKey405Attrs.put("payload", channelTag404);
        String catalogKey405 = catalogKey405Attrs.get("payload");
        cachedAccount = catalogKey405;
        route();
    }

    private void route() {
        String receiptKey406 = cachedAccount;
        String accountRef407 = "ref:" + receiptKey406 + ";";
        String voucherRef408 = "ref:" + accountRef407 + ";";
        this.pendingAccount = voucherRef408;
        attach();
    }

    private void attach() {
        String paymentTag409 = this.pendingAccount;
        String refundCode410 = paymentTag409;
        String shipmentCode411 = refundCode410;
        this.pendingAccount = shipmentCode411;
        prepare();
    }

    private void prepare() {
        String manifestKey412 = this.pendingAccount;
        String invoiceKey413 = "ref:" + manifestKey412 + ";";
        String batchTag414 = invoiceKey413;
        ShipmentRuleSelector.forward(batchTag414);
    }
}
