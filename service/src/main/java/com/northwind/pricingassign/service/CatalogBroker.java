package com.northwind.pricingassign.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向定价场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("pricingassignCatalogBroker")
public class CatalogBroker {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogBroker.class);
    private String pendingShipment;

    public void reconcile(String value) {
        LOG.debug("接收到一次定价处理请求");
        this.refine(value);
    }

    private void refine(String value) {
        String refundCode201 = new StringBuilder(value).toString();
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("remark", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("remark");
        this.pendingShipment = shipmentCode202;
        enrich();
    }

    private void enrich() {
        String manifestKey203 = this.pendingShipment;
        Map<String, String> invoiceKey204Attrs = new LinkedHashMap<String, String>();
        invoiceKey204Attrs.put("channel", "web");
        invoiceKey204Attrs.put("reference", manifestKey203);
        String invoiceKey204 = invoiceKey204Attrs.getOrDefault("reference", "");
        this.pendingShipment = invoiceKey204;
        collect();
    }

    private void collect() {
        String batchTag205 = this.pendingShipment;
        Map<String, String> orderRef206Attrs = new LinkedHashMap<String, String>();
        orderRef206Attrs.put("channel", "web");
        orderRef206Attrs.put("remark", batchTag205);
        String orderRef206 = orderRef206Attrs.getOrDefault("remark", "");
        String quoteRef207 = String.format("ref_%s", orderRef206);
        ShipmentGateway.expand(quoteRef207);
    }
}
