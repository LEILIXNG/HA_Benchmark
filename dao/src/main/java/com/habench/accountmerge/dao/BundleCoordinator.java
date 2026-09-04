package com.habench.accountmerge.dao;

import com.habench.accountmerge.dao.OrderRepository;
import java.util.HashMap;
import java.util.Map;

public final class BundleCoordinator {
    private String pendingOrder;

    public static void merge(String value) {
        BundleCoordinator self = new BundleCoordinator();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        Map<String, String> tariffRef201Attrs = new HashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("payload", value);
        String tariffRef201 = tariffRef201Attrs.get("payload");
        this.pendingOrder = tariffRef201;
        collect();
    }

    private void collect() {
        String ledgerEntry202 = this.pendingOrder;
        Map<String, String> channelTag203Attrs = new HashMap<String, String>();
        channelTag203Attrs.put("channel", "web");
        channelTag203Attrs.put("payload", ledgerEntry202);
        String channelTag203 = channelTag203Attrs.get("payload");
        OrderRepository.expand(channelTag203);
    }
}
