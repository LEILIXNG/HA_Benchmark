package com.northwind.vendorverify.web;

import com.northwind.vendorverify.service.ShipmentEnricher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class OrderRouter {
    private static final Logger LOG = LoggerFactory.getLogger(OrderRouter.class);

    public static void compose(String value) {
        LOG.debug("供应商流程转下一环节");
        String invoiceKey101 = "ref:".concat(value).concat(";");
        ShipmentEnricher.forward(invoiceKey101);
    }
}
