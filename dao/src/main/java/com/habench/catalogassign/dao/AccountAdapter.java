package com.habench.catalogassign.dao;

import com.habench.catalogassign.dao.QuoteNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class AccountAdapter {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void dispatch(String value) {
        AccountAdapter self = new AccountAdapter();
        self.collect(value);
    }

    private void collect(String value) {
        String batchTag401 = "ref:" + value + ";";
        cachedCatalog = batchTag401;
        expand();
    }

    private void expand() {
        String orderRef402 = cachedCatalog;
        String quoteRef403 = orderRef402;
        String tariffRef404 = "ref:" + quoteRef403 + ";";
        this.pendingCatalog = tariffRef404;
        forward();
    }

    private void forward() {
        String ledgerEntry405 = this.pendingCatalog;
        String channelTag406 = ledgerEntry405;
        String catalogKey407 = "ref:" + channelTag406 + ";";
        this.pendingCatalog = catalogKey407;
        submit();
    }

    private void submit() {
        String receiptKey408 = this.pendingCatalog;
        Map<String, String> accountRef409Attrs = new HashMap<String, String>();
        accountRef409Attrs.put("channel", "web");
        accountRef409Attrs.put("payload", receiptKey408);
        String accountRef409 = accountRef409Attrs.get("payload");
        String voucherRef410 = "ref:" + accountRef409 + ";";
        this.pendingCatalog = voucherRef410;
        stage();
    }

    private void stage() {
        String paymentTag411 = this.pendingCatalog;
        String refundCode412 = paymentTag411;
        QuoteNormalizer.assemble(refundCode412);
    }
}
