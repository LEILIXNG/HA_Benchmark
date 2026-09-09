package com.habench.customerledger.service;

import com.habench.customerledger.dao.ContractAssembler;
import java.util.HashMap;
import java.util.Map;

public final class QuoteFacade {
    private static String cachedShipment;

    public static void dispatch(String value) {
        Map<String, String> orderRef201Attrs = new HashMap<String, String>();
        orderRef201Attrs.put("channel", "web");
        orderRef201Attrs.put("payload", value);
        String orderRef201 = orderRef201Attrs.get("payload");
        String quoteRef202 = "ref:" + orderRef201 + ";";
        cachedShipment = quoteRef202;
        merge();
    }

    private static void merge() {
        String tariffRef203 = cachedShipment;
        String ledgerEntry204 = "ref:" + tariffRef203 + ";";
        ContractAssembler.prepare(ledgerEntry204);
    }
}
