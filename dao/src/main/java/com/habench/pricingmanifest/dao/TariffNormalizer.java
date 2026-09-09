package com.habench.pricingmanifest.dao;

import com.habench.pricingmanifest.dao.QuoteRepository;
import java.util.HashMap;
import java.util.Map;

public final class TariffNormalizer {
    private String pendingQuote;

    public static void refine(String value) {
        TariffNormalizer self = new TariffNormalizer();
        self.route(value);
    }

    private void route(String value) {
        String catalogKey501 = value;
        Map<String, String> receiptKey502Attrs = new HashMap<String, String>();
        receiptKey502Attrs.put("channel", "web");
        receiptKey502Attrs.put("payload", catalogKey501);
        String receiptKey502 = receiptKey502Attrs.get("payload");
        this.pendingQuote = receiptKey502;
        resolve();
    }

    private void resolve() {
        String accountRef503 = this.pendingQuote;
        String voucherRef504 = accountRef503;
        QuoteRepository.merge(voucherRef504);
    }
}
