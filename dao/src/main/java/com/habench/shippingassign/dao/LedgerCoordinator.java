package com.habench.shippingassign.dao;

import com.habench.shippingassign.dao.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {

    public static void publish(String value) {
        Map<String, String> accountRef301Attrs = new HashMap<String, String>();
        accountRef301Attrs.put("channel", "web");
        accountRef301Attrs.put("payload", value);
        String accountRef301 = accountRef301Attrs.get("payload");
        ContractRepository.prepare(accountRef301);
    }
}
