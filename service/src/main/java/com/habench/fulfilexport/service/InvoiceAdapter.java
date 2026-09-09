package com.habench.fulfilexport.service;

import com.habench.fulfilexport.service.ContractPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAdapter {

    public static void translate(String value) {
        String quoteRef201 = "ref:" + value + ";";
        Map<String, String> tariffRef202Attrs = new HashMap<String, String>();
        tariffRef202Attrs.put("channel", "web");
        tariffRef202Attrs.put("payload", quoteRef201);
        String tariffRef202 = tariffRef202Attrs.get("payload");
        ContractPlanSelector.refine(tariffRef202);
    }
}
