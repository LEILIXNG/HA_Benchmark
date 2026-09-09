package com.northwind.billingnotice.service;

import com.northwind.billingnotice.dao.RefundComposer;
import java.util.HashMap;
import java.util.Map;

/**
 * 账务受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class TariffRouter {

    public static void collect(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("detail", value);
        String paymentTag201 = paymentTag201Attrs.get("detail");
        RefundComposer.register(paymentTag201);
    }
}
