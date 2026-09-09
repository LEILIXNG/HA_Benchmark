package com.habench.pricingexport.web;

import com.habench.pricingexport.web.TariffRouter;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBroker {
    private String pendingAccount;
    private static String cachedAccount;

    public static void assemble(String value) {
        InvoiceBroker self = new InvoiceBroker();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        cachedAccount = quoteRef1;
        prepare();
    }

    private void prepare() {
        String tariffRef2 = cachedAccount;
        Map<String, String> ledgerEntry3Attrs = new HashMap<String, String>();
        ledgerEntry3Attrs.put("channel", "web");
        ledgerEntry3Attrs.put("payload", tariffRef2);
        String ledgerEntry3 = ledgerEntry3Attrs.get("payload");
        this.pendingAccount = ledgerEntry3;
        route();
    }

    private void route() {
        String channelTag4 = this.pendingAccount;
        String catalogKey5 = channelTag4;
        Map<String, String> receiptKey6Attrs = new HashMap<String, String>();
        receiptKey6Attrs.put("channel", "web");
        receiptKey6Attrs.put("payload", catalogKey5);
        String receiptKey6 = receiptKey6Attrs.get("payload");
        TariffRouter.collect(receiptKey6);
    }
}
