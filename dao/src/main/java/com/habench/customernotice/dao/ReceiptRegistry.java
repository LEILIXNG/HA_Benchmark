package com.habench.customernotice.dao;

import com.habench.customernotice.dao.VoucherScreen;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptRegistry {

    public static void compose(String value) {
        Map<String, String> refundCode401Attrs = new HashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("payload", value);
        String refundCode401 = refundCode401Attrs.get("payload");
        String shipmentCode402 = "ref:" + refundCode401 + ";";
        VoucherScreen.expand(shipmentCode402);
    }
}
