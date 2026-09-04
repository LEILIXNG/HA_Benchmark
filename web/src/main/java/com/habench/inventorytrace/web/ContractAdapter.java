package com.habench.inventorytrace.web;

import com.habench.inventorytrace.web.CatalogFacade;
import java.util.HashMap;
import java.util.Map;

public final class ContractAdapter {
    private static String cachedInvoice;

    public static void translate(String value) {
        String accountRef1 = "ref:" + value + ";";
        String voucherRef2 = "ref:" + accountRef1 + ";";
        cachedInvoice = voucherRef2;
        refine();
    }

    private static void refine() {
        String paymentTag3 = cachedInvoice;
        Map<String, String> refundCode4Attrs = new HashMap<String, String>();
        refundCode4Attrs.put("channel", "web");
        refundCode4Attrs.put("payload", paymentTag3);
        String refundCode4 = refundCode4Attrs.get("payload");
        String shipmentCode5 = "ref:" + refundCode4 + ";";
        CatalogFacade.stage(shipmentCode5);
    }
}
