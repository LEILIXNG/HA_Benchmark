package com.habench.ordercapture.dao;

import com.habench.ordercapture.dao.OrderStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountBroker {
    private String pendingChannel;

    public static void refine(String value) {
        AccountBroker self = new AccountBroker();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> channelTag301Attrs = new HashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("payload", value);
        String channelTag301 = channelTag301Attrs.get("payload");
        String catalogKey302 = channelTag301;
        this.pendingChannel = catalogKey302;
        assemble();
    }

    private void assemble() {
        String receiptKey303 = this.pendingChannel;
        String accountRef304 = "ref:" + receiptKey303 + ";";
        String voucherRef305 = "ref:" + accountRef304 + ";";
        OrderStrategySelector.resolve(voucherRef305);
    }
}
