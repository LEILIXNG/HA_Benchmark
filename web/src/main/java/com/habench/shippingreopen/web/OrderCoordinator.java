package com.habench.shippingreopen.web;

import com.habench.shippingreopen.service.AccountAdapter;
import java.util.HashMap;
import java.util.Map;

public final class OrderCoordinator {

    public static void translate(String value) {
        Map<String, String> accountRef301Attrs = new HashMap<String, String>();
        accountRef301Attrs.put("channel", "web");
        accountRef301Attrs.put("payload", value);
        String accountRef301 = accountRef301Attrs.get("payload");
        AccountAdapter.forward(accountRef301);
    }
}
