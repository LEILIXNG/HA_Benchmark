package com.habench.catalogadjust.service;

import com.habench.catalogadjust.dao.LedgerComposer;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentService {

    public static void prepare(String value) {
        Map<String, String> tariffRef201Attrs = new HashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("payload", value);
        String tariffRef201 = tariffRef201Attrs.get("payload");
        LedgerComposer.collect(tariffRef201);
    }
}
