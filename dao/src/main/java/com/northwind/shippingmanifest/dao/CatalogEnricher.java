package com.northwind.shippingmanifest.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class CatalogEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogEnricher.class);
    private String pendingShipment;

    public static void submit(String value) {
        LOG.debug("发运流程转下一环节");
        CatalogEnricher self = new CatalogEnricher();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> shipmentCode401Attrs = new LinkedHashMap<String, String>();
        shipmentCode401Attrs.put("channel", "web");
        shipmentCode401Attrs.put("detail", value);
        String shipmentCode401 = shipmentCode401Attrs.getOrDefault("detail", "");
        String manifestKey402 = String.format("ref_%s", shipmentCode401);
        this.pendingShipment = manifestKey402;
        expand();
    }

    private void expand() {
        String invoiceKey403 = this.pendingShipment;
        List<String> batchTag404Attrs = new ArrayList<String>();
        batchTag404Attrs.add("web");
        batchTag404Attrs.add(invoiceKey403);
        String batchTag404 = batchTag404Attrs.get(1);
        String orderRef405 = batchTag404;
        ShipmentEvaluator.compose(orderRef405);
    }
}
