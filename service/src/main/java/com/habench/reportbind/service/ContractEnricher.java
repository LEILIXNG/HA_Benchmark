package com.habench.reportbind.service;

import com.habench.reportbind.dao.LedgerFacade;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {

    public static void assemble(String value) {
        Map<String, String> voucherRef301Attrs = new HashMap<String, String>();
        voucherRef301Attrs.put("channel", "web");
        voucherRef301Attrs.put("payload", value);
        String voucherRef301 = voucherRef301Attrs.get("payload");
        LedgerFacade.assemble(voucherRef301);
    }
}
