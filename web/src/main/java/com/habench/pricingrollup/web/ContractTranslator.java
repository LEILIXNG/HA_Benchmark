package com.habench.pricingrollup.web;

import com.habench.pricingrollup.service.ChannelCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ContractTranslator {
    private String pendingChannel;

    public static void reconcile(String value) {
        ContractTranslator self = new ContractTranslator();
        self.enrich(value);
    }

    private void enrich(String value) {
        String channelTag201 = "ref:" + value + ";";
        String catalogKey202 = channelTag201;
        this.pendingChannel = catalogKey202;
        refine();
    }

    private void refine() {
        String receiptKey203 = this.pendingChannel;
        Map<String, String> accountRef204Attrs = new HashMap<String, String>();
        accountRef204Attrs.put("channel", "web");
        accountRef204Attrs.put("payload", receiptKey203);
        String accountRef204 = accountRef204Attrs.get("payload");
        String voucherRef205 = "ref:" + accountRef204 + ";";
        ChannelCoordinator.prepare(voucherRef205);
    }
}
