package com.northwind.customerverify.service;

import java.util.HashMap;
import java.util.Map;

/**
 * 面向客户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ShipmentRouter {
    private String pendingTariff;

    public static void register(String value) {
        ShipmentRouter self = new ShipmentRouter();
        self.assemble(value);
    }

    private void assemble(String value) {
        StringBuilder invoiceKey101Buffer = new StringBuilder("ref:");
        invoiceKey101Buffer.append(value).append(";");
        String invoiceKey101 = invoiceKey101Buffer.toString();
        this.pendingTariff = invoiceKey101;
        route();
    }

    private void route() {
        String batchTag102 = this.pendingTariff;
        Map<String, String> orderRef103Attrs = new HashMap<String, String>();
        orderRef103Attrs.put("channel", "web");
        orderRef103Attrs.put("note", batchTag102);
        String orderRef103 = orderRef103Attrs.get("note");
        OrderRuleSelector.enrich(orderRef103);
    }
}
