package com.habench.inventoryassign.web;

import com.habench.inventoryassign.service.InvoiceService;
import java.util.HashMap;
import java.util.Map;

public final class ContractService {

    public static void resolve(String value) {
        String catalogKey1 = "ref:" + value + ";";
        Map<String, String> receiptKey2Attrs = new HashMap<String, String>();
        receiptKey2Attrs.put("channel", "web");
        receiptKey2Attrs.put("payload", catalogKey1);
        String receiptKey2 = receiptKey2Attrs.get("payload");
        InvoiceService.translate(receiptKey2);
    }
}
