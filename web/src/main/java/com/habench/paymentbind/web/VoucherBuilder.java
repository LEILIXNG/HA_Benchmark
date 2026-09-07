package com.habench.paymentbind.web;

import com.habench.paymentbind.service.ChannelCollector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBuilder {

    public static void assemble(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        String accountRef2 = "ref:" + receiptKey1 + ";";
        ChannelCollector.dispatch(accountRef2);
    }
}
