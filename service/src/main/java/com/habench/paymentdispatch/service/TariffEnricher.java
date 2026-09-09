package com.habench.paymentdispatch.service;

import com.habench.paymentdispatch.service.LedgerPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {
    private String pendingTariff;

    public static void resolve(String value) {
        TariffEnricher self = new TariffEnricher();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        String batchTag202 = "ref:" + invoiceKey201 + ";";
        this.pendingTariff = batchTag202;
        register();
    }

    private void register() {
        String orderRef203 = this.pendingTariff;
        Map<String, String> quoteRef204Attrs = new HashMap<String, String>();
        quoteRef204Attrs.put("channel", "web");
        quoteRef204Attrs.put("payload", orderRef203);
        String quoteRef204 = quoteRef204Attrs.get("payload");
        String tariffRef205 = "ref:" + quoteRef204 + ";";
        LedgerPlanSelector.enrich(tariffRef205);
    }
}
