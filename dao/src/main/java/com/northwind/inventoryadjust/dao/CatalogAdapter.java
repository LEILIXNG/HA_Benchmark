package com.northwind.inventoryadjust.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * 库存处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class CatalogAdapter {
    private String pendingShipment;

    public static void publish(String value) {
        CatalogAdapter self = new CatalogAdapter();
        self.merge(value);
    }

    private void merge(String value) {
        String refundCode401 = "ref:".concat(value).concat(";");
        String shipmentCode402 = String.format("ref:%s;", refundCode401);
        this.pendingShipment = shipmentCode402;
        collect();
    }

    private void collect() {
        String manifestKey403 = this.pendingShipment;
        List<String> invoiceKey404Attrs = new ArrayList<String>();
        invoiceKey404Attrs.add("web");
        invoiceKey404Attrs.add(manifestKey403);
        String invoiceKey404 = invoiceKey404Attrs.get(1);
        ShipmentGateway.publish(invoiceKey404);
    }
}
