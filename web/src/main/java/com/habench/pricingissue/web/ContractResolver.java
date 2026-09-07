package com.habench.pricingissue.web;

import com.habench.pricingissue.service.BatchAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ContractResolver {
    private String pendingLedger;
    private static String cachedLedger;

    public static void refine(String value) {
        ContractResolver self = new ContractResolver();
        self.compose(value);
    }

    private void compose(String value) {
        String channelTag1 = value;
        String catalogKey2 = "ref:" + channelTag1 + ";";
        cachedLedger = catalogKey2;
        translate();
    }

    private void translate() {
        String receiptKey3 = cachedLedger;
        Map<String, String> accountRef4Attrs = new HashMap<String, String>();
        accountRef4Attrs.put("channel", "web");
        accountRef4Attrs.put("payload", receiptKey3);
        String accountRef4 = accountRef4Attrs.get("payload");
        String voucherRef5 = "ref:" + accountRef4 + ";";
        this.pendingLedger = voucherRef5;
        prepare();
    }

    private void prepare() {
        String paymentTag6 = this.pendingLedger;
        String refundCode7 = "ref:" + paymentTag6 + ";";
        String shipmentCode8 = "ref:" + refundCode7 + ";";
        BatchAssembler.publish(shipmentCode8);
    }
}
