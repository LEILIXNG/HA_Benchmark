package com.habench.catalogassign.dao;

import com.habench.catalogassign.dao.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAdapter {

    public static void translate(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        String channelTag202 = ledgerEntry201;
        ContractRepository.forward(channelTag202);
    }
}
