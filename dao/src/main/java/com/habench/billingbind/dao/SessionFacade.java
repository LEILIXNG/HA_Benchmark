package com.habench.billingbind.dao;

import com.habench.billingbind.dao.VoucherStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionFacade {

    public static void prepare(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        Map<String, String> accountRef202Attrs = new HashMap<String, String>();
        accountRef202Attrs.put("channel", "web");
        accountRef202Attrs.put("payload", receiptKey201);
        String accountRef202 = accountRef202Attrs.get("payload");
        VoucherStrategySelector.translate(accountRef202);
    }
}
