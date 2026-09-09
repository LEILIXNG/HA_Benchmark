package com.northwind.shippingverify.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向发运场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class RefundRouter {
    private static final Logger LOG = LoggerFactory.getLogger(RefundRouter.class);

    public static void normalize(String value) {
        LOG.debug("发运流程转下一环节");
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("detail", value);
        String paymentTag1 = paymentTag1Attrs.get("detail");
        final String refundCode2 = paymentTag1;
        OrderRegistry.forward(refundCode2);
    }
}
