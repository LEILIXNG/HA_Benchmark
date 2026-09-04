package com.habench.billingsettlequeue.service;

import com.habench.billingsettlequeue.dao.QuoteFacade;
import java.util.HashMap;
import java.util.Map;

public final class TariffCoordinator {
    private String pendingTariff;
    private static String cachedTariff;

    public static void reconcile(String value) {
        TariffCoordinator self = new TariffCoordinator();
        self.collect(value);
    }

    private void collect(String value) {
        String ledgerEntry401 = value;
        String channelTag402 = "ref:" + ledgerEntry401 + ";";
        cachedTariff = channelTag402;
        register();
    }

    private void register() {
        String catalogKey403 = cachedTariff;
        String receiptKey404 = "ref:" + catalogKey403 + ";";
        Map<String, String> accountRef405Attrs = new HashMap<String, String>();
        accountRef405Attrs.put("channel", "web");
        accountRef405Attrs.put("payload", receiptKey404);
        String accountRef405 = accountRef405Attrs.get("payload");
        this.pendingTariff = accountRef405;
        resolve();
    }

    private void resolve() {
        String voucherRef406 = this.pendingTariff;
        String paymentTag407 = voucherRef406;
        Map<String, String> refundCode408Attrs = new HashMap<String, String>();
        refundCode408Attrs.put("channel", "web");
        refundCode408Attrs.put("payload", paymentTag407);
        String refundCode408 = refundCode408Attrs.get("payload");
        QuoteFacade.forward(refundCode408);
    }
}
