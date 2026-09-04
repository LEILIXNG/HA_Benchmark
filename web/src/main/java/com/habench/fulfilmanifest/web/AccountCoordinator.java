package com.habench.fulfilmanifest.web;

import com.habench.fulfilmanifest.service.BatchAssembler;
import java.util.HashMap;
import java.util.Map;

public final class AccountCoordinator {

    public static void merge(String value) {
        String accountRef1 = "ref:" + value + ";";
        Map<String, String> voucherRef2Attrs = new HashMap<String, String>();
        voucherRef2Attrs.put("channel", "web");
        voucherRef2Attrs.put("payload", accountRef1);
        String voucherRef2 = voucherRef2Attrs.get("payload");
        BatchAssembler.normalize(voucherRef2);
    }
}
