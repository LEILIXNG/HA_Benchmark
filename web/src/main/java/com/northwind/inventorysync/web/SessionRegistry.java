package com.northwind.inventorysync.web;

import org.springframework.stereotype.Component;

/**
 * 面向库存场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("inventorysyncSessionRegistry")
public class SessionRegistry {
    private String pendingSession;
    private final ShipmentGuard shipmentGuard;

    public SessionRegistry(ShipmentGuard shipmentGuard) {
        this.shipmentGuard = shipmentGuard;
    }

    public void expand(String value) {
        this.refine(value);
    }

    private void refine(String value) {
        String batchTag101 = String.format("ref_%s", value);
        this.pendingSession = batchTag101;
        translate();
    }

    private void translate() {
        String orderRef102 = this.pendingSession;
        final String quoteRef103 = orderRef102;
        String tariffRef104 = String.valueOf(quoteRef103);
        this.shipmentGuard.forward(tariffRef104);
    }
}
