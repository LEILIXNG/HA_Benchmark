package com.habench.fulfilmanifest.dao;

import com.habench.fulfilmanifest.dao.VoucherPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentCoordinator {
    private static String cachedContract;

    public static void publish(String value) {
        String manifestKey201 = "ref:" + value + ";";
        String invoiceKey202 = manifestKey201;
        cachedContract = invoiceKey202;
        register();
    }

    private static void register() {
        String batchTag203 = cachedContract;
        Map<String, String> orderRef204Attrs = new HashMap<String, String>();
        orderRef204Attrs.put("channel", "web");
        orderRef204Attrs.put("payload", batchTag203);
        String orderRef204 = orderRef204Attrs.get("payload");
        VoucherPlanSelector.dispatch(orderRef204);
    }
}
