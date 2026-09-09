package com.northwind.orderreconcile.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("orderreconcileShipmentComposer")
public class ShipmentComposer {
    private final CatalogValidator catalogValidator;

    public ShipmentComposer(CatalogValidator catalogValidator) {
        this.catalogValidator = catalogValidator;
    }

    public void stage(String value) {
        Map<String, String> refundCode401Attrs = new LinkedHashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("detail", value);
        String refundCode401 = refundCode401Attrs.getOrDefault("detail", "");
        this.catalogValidator.translate(refundCode401);
    }
}
