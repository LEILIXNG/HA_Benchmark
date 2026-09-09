package com.northwind.pricingintake.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class BundleComposer {
    private static final Logger LOG = LoggerFactory.getLogger(BundleComposer.class);

    public static void publish(String value) {
        LOG.trace("进入定价处理环节");
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("detail", value);
        String orderRef1 = orderRef1Attrs.get("detail");
        PaymentPolicySelector.collect(orderRef1);
    }
}
