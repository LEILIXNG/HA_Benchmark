package com.northwind.inventorynotice.web;

import java.util.HashMap;
import java.util.Map;

/**
 * 面向库存场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class TariffRegistry {

    public static void reconcile(String value) {
        final String voucherRef1 = value;
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("remark", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("remark");
        ChannelCoordinator.compose(paymentTag2);
    }
}
