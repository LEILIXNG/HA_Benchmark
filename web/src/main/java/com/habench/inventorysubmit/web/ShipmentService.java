package com.habench.inventorysubmit.web;

import com.habench.inventorysubmit.service.CatalogAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentService {

    public static void forward(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        String ledgerEntry102 = "ref:" + tariffRef101 + ";";
        CatalogAdapter.dispatch(ledgerEntry102);
    }
}
