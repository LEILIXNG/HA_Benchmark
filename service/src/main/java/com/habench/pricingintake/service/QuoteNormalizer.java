package com.habench.pricingintake.service;

import com.habench.pricingintake.dao.TariffFacade;
import java.util.HashMap;
import java.util.Map;

public final class QuoteNormalizer {
    private String pendingVoucher;

    public static void merge(String value) {
        QuoteNormalizer self = new QuoteNormalizer();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        this.pendingVoucher = catalogKey201;
        resolve();
    }

    private void resolve() {
        String receiptKey202 = this.pendingVoucher;
        String accountRef203 = receiptKey202;
        TariffFacade.route(accountRef203);
    }
}
