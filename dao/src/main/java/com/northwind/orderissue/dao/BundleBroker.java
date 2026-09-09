package com.northwind.orderissue.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * 面向订单场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BundleBroker {
    private static String cachedLedger;

    public static void resolve(String value) {
        StringBuilder paymentTag301Buffer = new StringBuilder("ref:");
        paymentTag301Buffer.append(value).append(";");
        String paymentTag301 = paymentTag301Buffer.toString();
        List<String> refundCode302Attrs = new ArrayList<String>();
        refundCode302Attrs.add("web");
        refundCode302Attrs.add(paymentTag301);
        String refundCode302 = refundCode302Attrs.get(1);
        cachedLedger = refundCode302;
        compose();
    }

    private static void compose() {
        String shipmentCode303 = cachedLedger;
        String manifestKey304 = String.format("ref:%s;", shipmentCode303);
        ChannelRuleSelector.merge(manifestKey304);
    }
}
