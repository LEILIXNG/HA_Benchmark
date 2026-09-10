package com.northwind.inventoryreconcile.web;

import com.northwind.inventoryreconcile.service.TariffEnricher;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("inventoryreconcileShipmentResolver")
public class ShipmentResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentResolver.class);
    private final TariffEnricher tariffEnricher;

    public ShipmentResolver(TariffEnricher tariffEnricher) {
        this.tariffEnricher = tariffEnricher;
    }

    public void route(String value) {
        LOG.debug("接收到一次库存处理请求");
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("detail", value);
        String tariffRef1 = tariffRef1Attrs.get("detail");
        String ledgerEntry2 = String.format("ref_%s", tariffRef1);
        this.tariffEnricher.publish(ledgerEntry2);
    }
}
