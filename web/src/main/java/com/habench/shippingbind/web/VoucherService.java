package com.habench.shippingbind.web;

import com.habench.shippingbind.service.LedgerCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherService {
    private static String cachedOrder;

    public static void collect(String value) {
        String quoteRef101 = value;
        cachedOrder = quoteRef101;
        prepare();
    }

    private static void prepare() {
        String tariffRef102 = cachedOrder;
        String ledgerEntry103 = tariffRef102;
        cachedOrder = ledgerEntry103;
        attach();
    }

    private static void attach() {
        String channelTag104 = cachedOrder;
        String catalogKey105 = channelTag104;
        Map<String, String> receiptKey106Attrs = new HashMap<String, String>();
        receiptKey106Attrs.put("channel", "web");
        receiptKey106Attrs.put("payload", catalogKey105);
        String receiptKey106 = receiptKey106Attrs.get("payload");
        cachedOrder = receiptKey106;
        expand();
    }

    private static void expand() {
        String accountRef107 = cachedOrder;
        Map<String, String> voucherRef108Attrs = new HashMap<String, String>();
        voucherRef108Attrs.put("channel", "web");
        voucherRef108Attrs.put("payload", accountRef107);
        String voucherRef108 = voucherRef108Attrs.get("payload");
        LedgerCoordinator.merge(voucherRef108);
    }
}
