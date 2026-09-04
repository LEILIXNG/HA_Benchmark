package com.habench.fulfilassign.service;

import com.habench.fulfilassign.service.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class LedgerService {

    public static void route(String value) {
        Map<String, String> accountRef401Attrs = new HashMap<String, String>();
        accountRef401Attrs.put("channel", "web");
        accountRef401Attrs.put("payload", value);
        String accountRef401 = accountRef401Attrs.get("payload");
        Map<String, String> voucherRef402Attrs = new HashMap<String, String>();
        voucherRef402Attrs.put("channel", "web");
        voucherRef402Attrs.put("payload", accountRef401);
        String voucherRef402 = voucherRef402Attrs.get("payload");
        ContractRepository.publish(voucherRef402);
    }
}
