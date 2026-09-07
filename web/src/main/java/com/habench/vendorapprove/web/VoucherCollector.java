package com.habench.vendorapprove.web;

import com.habench.vendorapprove.service.ContractRouter;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCollector {
    private String pendingChannel;

    public static void expand(String value) {
        VoucherCollector self = new VoucherCollector();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        Map<String, String> tariffRef102Attrs = new HashMap<String, String>();
        tariffRef102Attrs.put("channel", "web");
        tariffRef102Attrs.put("payload", quoteRef101);
        String tariffRef102 = tariffRef102Attrs.get("payload");
        this.pendingChannel = tariffRef102;
        compose();
    }

    private void compose() {
        String ledgerEntry103 = this.pendingChannel;
        String channelTag104 = "ref:" + ledgerEntry103 + ";";
        this.pendingChannel = channelTag104;
        merge();
    }

    private void merge() {
        String catalogKey105 = this.pendingChannel;
        String receiptKey106 = catalogKey105;
        ContractRouter.stage(receiptKey106);
    }
}
