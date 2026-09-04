package com.habench.customerledger.dao;

import com.habench.customerledger.dao.TariffPolicy;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptEnricher {

    public static void forward(String value) {
        Map<String, String> tariffRef401Attrs = new HashMap<String, String>();
        tariffRef401Attrs.put("channel", "web");
        tariffRef401Attrs.put("payload", value);
        String tariffRef401 = tariffRef401Attrs.get("payload");
        String ledgerEntry402 = "ref:" + tariffRef401 + ";";
        TariffPolicy.attach(ledgerEntry402);
    }
}
