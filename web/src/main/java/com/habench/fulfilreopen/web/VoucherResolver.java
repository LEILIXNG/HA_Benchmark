package com.habench.fulfilreopen.web;

import com.habench.fulfilreopen.service.ContractRouter;
import java.util.HashMap;
import java.util.Map;

public final class VoucherResolver {

    public static void merge(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        ContractRouter.publish(batchTag1);
    }
}
