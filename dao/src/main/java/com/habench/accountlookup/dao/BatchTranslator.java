package com.habench.accountlookup.dao;

import com.habench.accountlookup.dao.VoucherRepository;
import java.util.HashMap;
import java.util.Map;

public final class BatchTranslator {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void enrich(String value) {
        BatchTranslator self = new BatchTranslator();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> quoteRef301Attrs = new HashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("payload", value);
        String quoteRef301 = quoteRef301Attrs.get("payload");
        cachedVoucher = quoteRef301;
        submit();
    }

    private void submit() {
        String tariffRef302 = cachedVoucher;
        Map<String, String> ledgerEntry303Attrs = new HashMap<String, String>();
        ledgerEntry303Attrs.put("channel", "web");
        ledgerEntry303Attrs.put("payload", tariffRef302);
        String ledgerEntry303 = ledgerEntry303Attrs.get("payload");
        this.pendingVoucher = ledgerEntry303;
        refine();
    }

    private void refine() {
        String channelTag304 = this.pendingVoucher;
        String catalogKey305 = channelTag304;
        VoucherRepository.reconcile(catalogKey305);
    }
}
