package com.habench.paymentledger.dao;

import com.habench.paymentledger.dao.LedgerFacade;
import java.util.HashMap;
import java.util.Map;

public final class VoucherComposer {

    public static void forward(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        String channelTag202 = "ref:" + ledgerEntry201 + ";";
        LedgerFacade.merge(channelTag202);
    }
}
