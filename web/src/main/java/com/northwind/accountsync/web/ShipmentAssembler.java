package com.northwind.accountsync.web;

import com.northwind.accountsync.service.OrderCoordinator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("accountsyncShipmentAssembler")
public class ShipmentAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentAssembler.class);
    private final OrderCoordinator orderCoordinator;

    public ShipmentAssembler(OrderCoordinator orderCoordinator) {
        this.orderCoordinator = orderCoordinator;
    }

    public void translate(String value) {
        LOG.debug("账户流程转下一环节");
        final String manifestKey1 = value;
        Map<String, String> invoiceKey2Attrs = new LinkedHashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("remark", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.getOrDefault("remark", "");
        this.orderCoordinator.reconcile(invoiceKey2);
    }
}
