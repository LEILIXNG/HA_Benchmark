package com.northwind.inventoryreview.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向库存场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("inventoryreviewRefundBuilder")
public class RefundBuilder {

    public void forward(String value) {
        Map<String, String> invoiceKey101Attrs = new LinkedHashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("detail", value);
        String invoiceKey101 = invoiceKey101Attrs.getOrDefault("detail", "");
        String batchTag102 = "ref_" + invoiceKey101;
        ShipmentPlanSelector.publish(batchTag102);
    }
}
