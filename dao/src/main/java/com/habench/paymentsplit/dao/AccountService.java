package com.habench.paymentsplit.dao;

import com.habench.paymentsplit.dao.RefundExecutor;
import java.util.HashMap;
import java.util.Map;

public final class AccountService {

    public static void stage(String value) {
        Map<String, String> ledgerEntry501Attrs = new HashMap<String, String>();
        ledgerEntry501Attrs.put("channel", "web");
        ledgerEntry501Attrs.put("payload", value);
        String ledgerEntry501 = ledgerEntry501Attrs.get("payload");
        String channelTag502 = ledgerEntry501;
        RefundExecutor.forward(channelTag502);
    }
}
