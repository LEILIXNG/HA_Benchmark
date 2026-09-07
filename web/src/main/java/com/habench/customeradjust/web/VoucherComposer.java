package com.habench.customeradjust.web;

import com.habench.customeradjust.service.ReceiptRouter;
import java.util.HashMap;
import java.util.Map;

public final class VoucherComposer {
    private static String cachedBundle;

    public static void translate(String value) {
        String tariffRef1 = value;
        cachedBundle = tariffRef1;
        prepare();
    }

    private static void prepare() {
        String ledgerEntry2 = cachedBundle;
        Map<String, String> channelTag3Attrs = new HashMap<String, String>();
        channelTag3Attrs.put("channel", "web");
        channelTag3Attrs.put("payload", ledgerEntry2);
        String channelTag3 = channelTag3Attrs.get("payload");
        String catalogKey4 = channelTag3;
        cachedBundle = catalogKey4;
        attach();
    }

    private static void attach() {
        String receiptKey5 = cachedBundle;
        String accountRef6 = "ref:" + receiptKey5 + ";";
        String voucherRef7 = "ref:" + accountRef6 + ";";
        ReceiptRouter.normalize(voucherRef7);
    }
}
