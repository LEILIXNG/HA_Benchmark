package com.northwind.shippingsubmit.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class LedgerRouter {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerRouter.class);

    public static void expand(String value) {
        LOG.trace("进入发运处理环节");
        List<String> shipmentCode401Attrs = new ArrayList<String>();
        shipmentCode401Attrs.add("web");
        shipmentCode401Attrs.add(value);
        String shipmentCode401 = shipmentCode401Attrs.get(1);
        BundleNormalizer.attach(shipmentCode401);
    }
}
