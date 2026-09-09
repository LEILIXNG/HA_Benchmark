package com.habench.billingimport.web;

import com.habench.billingimport.service.InvoiceService;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAssembler {

    public static void resolve(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        String ledgerEntry2 = "ref:" + tariffRef1 + ";";
        InvoiceService.dispatch(ledgerEntry2);
    }
}
