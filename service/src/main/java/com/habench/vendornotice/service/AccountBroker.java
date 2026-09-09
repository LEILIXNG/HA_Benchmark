package com.habench.vendornotice.service;

import com.habench.vendornotice.service.ChannelAdapter;
import java.util.HashMap;
import java.util.Map;

public final class AccountBroker {
    private String pendingBatch;
    private static String cachedBatch;

    public static void resolve(String value) {
        AccountBroker self = new AccountBroker();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        this.pendingBatch = ledgerEntry301;
        assemble();
    }

    private void assemble() {
        String channelTag302 = this.pendingBatch;
        Map<String, String> catalogKey303Attrs = new HashMap<String, String>();
        catalogKey303Attrs.put("channel", "web");
        catalogKey303Attrs.put("payload", channelTag302);
        String catalogKey303 = catalogKey303Attrs.get("payload");
        cachedBatch = catalogKey303;
        refine();
    }

    private void refine() {
        String receiptKey304 = cachedBatch;
        Map<String, String> accountRef305Attrs = new HashMap<String, String>();
        accountRef305Attrs.put("channel", "web");
        accountRef305Attrs.put("payload", receiptKey304);
        String accountRef305 = accountRef305Attrs.get("payload");
        Map<String, String> voucherRef306Attrs = new HashMap<String, String>();
        voucherRef306Attrs.put("channel", "web");
        voucherRef306Attrs.put("payload", accountRef305);
        String voucherRef306 = voucherRef306Attrs.get("payload");
        cachedBatch = voucherRef306;
        publish();
    }

    private void publish() {
        String paymentTag307 = cachedBatch;
        String refundCode308 = paymentTag307;
        String shipmentCode309 = refundCode308;
        ChannelAdapter.collect(shipmentCode309);
    }
}
