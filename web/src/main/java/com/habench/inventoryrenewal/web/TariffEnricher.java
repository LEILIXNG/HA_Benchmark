package com.habench.inventoryrenewal.web;

import com.habench.inventoryrenewal.web.RefundCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {
    private String pendingLedger;
    private static String cachedLedger;

    public static void normalize(String value) {
        TariffEnricher self = new TariffEnricher();
        self.submit(value);
    }

    private void submit(String value) {
        String tariffRef101 = "ref:" + value + ";";
        Map<String, String> ledgerEntry102Attrs = new HashMap<String, String>();
        ledgerEntry102Attrs.put("channel", "web");
        ledgerEntry102Attrs.put("payload", tariffRef101);
        String ledgerEntry102 = ledgerEntry102Attrs.get("payload");
        this.pendingLedger = ledgerEntry102;
        enrich();
    }

    private void enrich() {
        String channelTag103 = this.pendingLedger;
        String catalogKey104 = "ref:" + channelTag103 + ";";
        String receiptKey105 = "ref:" + catalogKey104 + ";";
        cachedLedger = receiptKey105;
        prepare();
    }

    private void prepare() {
        String accountRef106 = cachedLedger;
        String voucherRef107 = "ref:" + accountRef106 + ";";
        this.pendingLedger = voucherRef107;
        collect();
    }

    private void collect() {
        String paymentTag108 = this.pendingLedger;
        Map<String, String> refundCode109Attrs = new HashMap<String, String>();
        refundCode109Attrs.put("channel", "web");
        refundCode109Attrs.put("payload", paymentTag108);
        String refundCode109 = refundCode109Attrs.get("payload");
        RefundCoordinator.expand(refundCode109);
    }
}
