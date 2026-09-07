package com.habench.inventorysubmit.service;

import com.habench.inventorysubmit.dao.ContractBuilder;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBuilder {

    public static void assemble(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        ContractBuilder.dispatch(tariffRef101);
    }
}
