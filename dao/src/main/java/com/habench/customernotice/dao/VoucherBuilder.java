package com.habench.customernotice.dao;

import com.habench.customernotice.dao.RefundExecutor;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBuilder {

    public static void expand(String value) {
        Map<String, String> receiptKey301Attrs = new HashMap<String, String>();
        receiptKey301Attrs.put("channel", "web");
        receiptKey301Attrs.put("payload", value);
        String receiptKey301 = receiptKey301Attrs.get("payload");
        String accountRef302 = "ref:" + receiptKey301 + ";";
        RefundExecutor.route(accountRef302);
    }
}
