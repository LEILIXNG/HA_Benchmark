package com.habench.customerbatch.web;

import com.habench.customerbatch.service.LedgerAdapter;
import java.util.HashMap;
import java.util.Map;

public final class RefundService {
    private static String cachedBatch;

    public static void translate(String value) {
        String channelTag1 = "ref:" + value + ";";
        String catalogKey2 = "ref:" + channelTag1 + ";";
        cachedBatch = catalogKey2;
        assemble();
    }

    private static void assemble() {
        String receiptKey3 = cachedBatch;
        String accountRef4 = receiptKey3;
        Map<String, String> voucherRef5Attrs = new HashMap<String, String>();
        voucherRef5Attrs.put("channel", "web");
        voucherRef5Attrs.put("payload", accountRef4);
        String voucherRef5 = voucherRef5Attrs.get("payload");
        LedgerAdapter.assemble(voucherRef5);
    }
}
