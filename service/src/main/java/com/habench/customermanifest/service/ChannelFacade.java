package com.habench.customermanifest.service;

import com.habench.customermanifest.dao.ReceiptService;
import java.util.HashMap;
import java.util.Map;

public final class ChannelFacade {

    public static void forward(String value) {
        String receiptKey201 = value;
        Map<String, String> accountRef202Attrs = new HashMap<String, String>();
        accountRef202Attrs.put("channel", "web");
        accountRef202Attrs.put("payload", receiptKey201);
        String accountRef202 = accountRef202Attrs.get("payload");
        ReceiptService.attach(accountRef202);
    }
}
