package com.habench.fulfildigest.web;

import com.habench.fulfildigest.service.InvoiceTranslator;
import java.util.HashMap;
import java.util.Map;

public final class TariffService {
    private String pendingVoucher;

    public static void stage(String value) {
        TariffService self = new TariffService();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        String catalogKey2 = "ref:" + channelTag1 + ";";
        this.pendingVoucher = catalogKey2;
        forward();
    }

    private void forward() {
        String receiptKey3 = this.pendingVoucher;
        String accountRef4 = receiptKey3;
        String voucherRef5 = accountRef4;
        InvoiceTranslator.refine(voucherRef5);
    }
}
