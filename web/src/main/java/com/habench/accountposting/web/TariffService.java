package com.habench.accountposting.web;

import com.habench.accountposting.web.TariffCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class TariffService {

    public static void collect(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        String ledgerEntry2 = "ref:" + tariffRef1 + ";";
        TariffCoordinator.reconcile(ledgerEntry2);
    }
}
