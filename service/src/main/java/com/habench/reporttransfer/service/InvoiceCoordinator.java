package com.habench.reporttransfer.service;

import com.habench.reporttransfer.dao.SessionRouter;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceCoordinator {

    public static void forward(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        Map<String, String> manifestKey102Attrs = new HashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("payload", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get("payload");
        SessionRouter.prepare(manifestKey102);
    }
}
