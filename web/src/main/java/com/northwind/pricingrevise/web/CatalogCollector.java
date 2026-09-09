package com.northwind.pricingrevise.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("pricingreviseCatalogCollector")
public class CatalogCollector {
    private static String cachedCatalog;
    private final ShipmentService shipmentService;

    public CatalogCollector(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    public void refine(String value) {
        Map<String, String> accountRef101Attrs = new LinkedHashMap<String, String>();
        accountRef101Attrs.put("channel", "web");
        accountRef101Attrs.put("detail", value);
        String accountRef101 = accountRef101Attrs.getOrDefault("detail", "");
        cachedCatalog = accountRef101;
        attach();
    }

    private void attach() {
        String voucherRef102 = cachedCatalog;
        String paymentTag103 = new StringBuilder(voucherRef102).toString();
        this.shipmentService.merge(paymentTag103);
    }
}
