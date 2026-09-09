package com.northwind.paymentrollup.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向支付场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("paymentrollupShipmentBroker")
public class ShipmentBroker {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentBroker.class);
    private final InvoiceNormalizer invoiceNormalizer;

    public ShipmentBroker(InvoiceNormalizer invoiceNormalizer) {
        this.invoiceNormalizer = invoiceNormalizer;
    }

    public void enrich(String value) {
        LOG.debug("开始整理支付字段");
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("detail", value);
        String refundCode101 = refundCode101Attrs.get("detail");
        String shipmentCode102 = refundCode101;
        this.invoiceNormalizer.assemble(shipmentCode102);
    }
}
