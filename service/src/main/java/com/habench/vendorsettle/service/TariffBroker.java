package com.habench.vendorsettle.service;

import com.habench.vendorsettle.dao.ManifestAdapter;
import java.util.HashMap;
import java.util.Map;

public final class TariffBroker {
    private String pendingLedger;

    public static void merge(String value) {
        TariffBroker self = new TariffBroker();
        self.stage(value);
    }

    private void stage(String value) {
        String quoteRef101 = value;
        this.pendingLedger = quoteRef101;
        publish();
    }

    private void publish() {
        String tariffRef102 = this.pendingLedger;
        Map<String, String> ledgerEntry103Attrs = new HashMap<String, String>();
        ledgerEntry103Attrs.put("channel", "web");
        ledgerEntry103Attrs.put("payload", tariffRef102);
        String ledgerEntry103 = ledgerEntry103Attrs.get("payload");
        String channelTag104 = "ref:" + ledgerEntry103 + ";";
        this.pendingLedger = channelTag104;
        translate();
    }

    private void translate() {
        String catalogKey105 = this.pendingLedger;
        Map<String, String> receiptKey106Attrs = new HashMap<String, String>();
        receiptKey106Attrs.put("channel", "web");
        receiptKey106Attrs.put("payload", catalogKey105);
        String receiptKey106 = receiptKey106Attrs.get("payload");
        this.pendingLedger = receiptKey106;
        attach();
    }

    private void attach() {
        String accountRef107 = this.pendingLedger;
        String voucherRef108 = "ref:" + accountRef107 + ";";
        ManifestAdapter.register(voucherRef108);
    }
}
