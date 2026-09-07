package com.habench.catalogreopen.service;

import com.habench.catalogreopen.dao.ChannelCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class AccountResolver {
    private String pendingOrder;

    public static void stage(String value) {
        AccountResolver self = new AccountResolver();
        self.publish(value);
    }

    private void publish(String value) {
        String invoiceKey101 = value;
        this.pendingOrder = invoiceKey101;
        register();
    }

    private void register() {
        String batchTag102 = this.pendingOrder;
        Map<String, String> orderRef103Attrs = new HashMap<String, String>();
        orderRef103Attrs.put("channel", "web");
        orderRef103Attrs.put("payload", batchTag102);
        String orderRef103 = orderRef103Attrs.get("payload");
        String quoteRef104 = orderRef103;
        ChannelCoordinator.submit(quoteRef104);
    }
}
