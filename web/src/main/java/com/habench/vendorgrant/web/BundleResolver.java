package com.habench.vendorgrant.web;

import com.habench.vendorgrant.web.ContractBroker;
import java.util.HashMap;
import java.util.Map;

public final class BundleResolver {
    private static String cachedOrder;

    public static void assemble(String value) {
        String batchTag1 = value;
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        cachedOrder = orderRef2;
        collect();
    }

    private static void collect() {
        String quoteRef3 = cachedOrder;
        String tariffRef4 = "ref:" + quoteRef3 + ";";
        ContractBroker.publish(tariffRef4);
    }
}
