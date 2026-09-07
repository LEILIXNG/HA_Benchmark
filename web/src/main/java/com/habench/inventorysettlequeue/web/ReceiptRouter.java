package com.habench.inventorysettlequeue.web;

import com.habench.inventorysettlequeue.service.LedgerService;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptRouter {

    public static void assemble(String value) {
        Map<String, String> catalogKey101Attrs = new HashMap<String, String>();
        catalogKey101Attrs.put("channel", "web");
        catalogKey101Attrs.put("payload", value);
        String catalogKey101 = catalogKey101Attrs.get("payload");
        LedgerService.refine(catalogKey101);
    }
}
