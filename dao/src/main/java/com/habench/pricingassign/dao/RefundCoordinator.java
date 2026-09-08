package com.habench.pricingassign.dao;

import com.habench.pricingassign.dao.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class RefundCoordinator {

    public static void normalize(String value) {
        Map<String, String> tariffRef401Attrs = new HashMap<String, String>();
        tariffRef401Attrs.put("channel", "web");
        tariffRef401Attrs.put("payload", value);
        String tariffRef401 = tariffRef401Attrs.get("payload");
        String ledgerEntry402 = tariffRef401;
        ContractRepository.submit(ledgerEntry402);
    }
}
