package com.habench.pricingbind.web;

import com.habench.pricingbind.service.CatalogFacade;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceCoordinator {

    public static void forward(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = orderRef1;
        CatalogFacade.expand(quoteRef2);
    }
}
