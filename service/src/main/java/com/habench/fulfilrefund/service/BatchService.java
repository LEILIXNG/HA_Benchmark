package com.habench.fulfilrefund.service;

import com.habench.fulfilrefund.service.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class BatchService {

    public static void collect(String value) {
        Map<String, String> ledgerEntry401Attrs = new HashMap<String, String>();
        ledgerEntry401Attrs.put("channel", "web");
        ledgerEntry401Attrs.put("payload", value);
        String ledgerEntry401 = ledgerEntry401Attrs.get("payload");
        String channelTag402 = ledgerEntry401;
        ContractRepository.dispatch(channelTag402);
    }
}
