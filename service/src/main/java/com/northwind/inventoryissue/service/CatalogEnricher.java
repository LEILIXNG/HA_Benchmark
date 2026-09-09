package com.northwind.inventoryissue.service;

import com.northwind.inventoryissue.dao.ShipmentRouter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("inventoryissueCatalogEnricher")
public class CatalogEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogEnricher.class);
    private static String cachedManifest;
    private final ShipmentRouter shipmentRouter;

    public CatalogEnricher(ShipmentRouter shipmentRouter) {
        this.shipmentRouter = shipmentRouter;
    }

    public void reconcile(String value) {
        LOG.debug("开始整理库存字段");
        String voucherRef101 = String.valueOf(value);
        cachedManifest = voucherRef101;
        attach();
    }

    private void attach() {
        String paymentTag102 = cachedManifest;
        Map<String, String> refundCode103Attrs = new LinkedHashMap<String, String>();
        refundCode103Attrs.put("channel", "web");
        refundCode103Attrs.put("note", paymentTag102);
        String refundCode103 = refundCode103Attrs.getOrDefault("note", "");
        Map<String, String> shipmentCode104Attrs = new LinkedHashMap<String, String>();
        shipmentCode104Attrs.put("channel", "web");
        shipmentCode104Attrs.put("reference", refundCode103);
        String shipmentCode104 = shipmentCode104Attrs.getOrDefault("reference", "");
        this.shipmentRouter.compose(shipmentCode104);
    }
}
