package com.habench.paymentrevise.web;

import com.habench.paymentrevise.web.InvoiceRepository;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentAdapter {
    private String pendingInvoice;

    public static void stage(String value) {
        ShipmentAdapter self = new ShipmentAdapter();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        String catalogKey2 = channelTag1;
        this.pendingInvoice = catalogKey2;
        prepare();
    }

    private void prepare() {
        String receiptKey3 = this.pendingInvoice;
        Map<String, String> accountRef4Attrs = new HashMap<String, String>();
        accountRef4Attrs.put("channel", "web");
        accountRef4Attrs.put("payload", receiptKey3);
        String accountRef4 = accountRef4Attrs.get("payload");
        InvoiceRepository.normalize(accountRef4);
    }
}
