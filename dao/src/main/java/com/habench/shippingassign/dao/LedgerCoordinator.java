package com.habench.shippingassign.dao;

import com.habench.shippingassign.dao.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {

    public static void publish(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        ContractRepository.prepare(ledgerEntry301);
    }
}
