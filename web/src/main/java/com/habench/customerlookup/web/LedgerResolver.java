package com.habench.customerlookup.web;

import com.habench.customerlookup.service.ShipmentRouter;
import java.util.HashMap;
import java.util.Map;

public final class LedgerResolver {
    private String pendingAccount;
    private static String cachedAccount;

    public static void attach(String value) {
        LedgerResolver self = new LedgerResolver();
        self.expand(value);
    }

    private void expand(String value) {
        String shipmentCode1 = value;
        cachedAccount = shipmentCode1;
        prepare();
    }

    private void prepare() {
        String manifestKey2 = cachedAccount;
        String invoiceKey3 = "ref:" + manifestKey2 + ";";
        Map<String, String> batchTag4Attrs = new HashMap<String, String>();
        batchTag4Attrs.put("channel", "web");
        batchTag4Attrs.put("payload", invoiceKey3);
        String batchTag4 = batchTag4Attrs.get("payload");
        this.pendingAccount = batchTag4;
        submit();
    }

    private void submit() {
        String orderRef5 = this.pendingAccount;
        Map<String, String> quoteRef6Attrs = new HashMap<String, String>();
        quoteRef6Attrs.put("channel", "web");
        quoteRef6Attrs.put("payload", orderRef5);
        String quoteRef6 = quoteRef6Attrs.get("payload");
        this.pendingAccount = quoteRef6;
        publish();
    }

    private void publish() {
        String tariffRef7 = this.pendingAccount;
        String ledgerEntry8 = "ref:" + tariffRef7 + ";";
        ShipmentRouter.refine(ledgerEntry8);
    }
}
