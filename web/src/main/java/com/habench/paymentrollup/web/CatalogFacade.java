package com.habench.paymentrollup.web;

import com.habench.paymentrollup.web.VoucherRouter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogFacade {

    public static void stage(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        String shipmentCode102 = refundCode101;
        VoucherRouter.merge(shipmentCode102);
    }
}
