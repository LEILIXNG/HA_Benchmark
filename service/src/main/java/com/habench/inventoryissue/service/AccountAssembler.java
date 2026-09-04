package com.habench.inventoryissue.service;

import com.habench.inventoryissue.service.ChannelRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountAssembler {
    private String pendingLedger;

    public static void compose(String value) {
        AccountAssembler self = new AccountAssembler();
        self.expand(value);
    }

    private void expand(String value) {
        String accountRef201 = value;
        Map<String, String> voucherRef202Attrs = new HashMap<String, String>();
        voucherRef202Attrs.put("channel", "web");
        voucherRef202Attrs.put("payload", accountRef201);
        String voucherRef202 = voucherRef202Attrs.get("payload");
        this.pendingLedger = voucherRef202;
        register();
    }

    private void register() {
        String paymentTag203 = this.pendingLedger;
        String refundCode204 = "ref:" + paymentTag203 + ";";
        ChannelRuleSelector.expand(refundCode204);
    }
}
