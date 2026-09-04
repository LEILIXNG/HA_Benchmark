package com.habench.cataloglookup.service;

import com.habench.cataloglookup.service.AccountExecutor;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCoordinator {

    public static void submit(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        String invoiceKey202 = manifestKey201;
        AccountExecutor.submit(invoiceKey202);
    }
}
