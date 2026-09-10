package com.northwind.orderreconcile.web;

import com.northwind.orderreconcile.service.ManifestEnricher;
import org.springframework.stereotype.Component;

/**
 * 订单处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("orderreconcileShipmentCollector")
public class ShipmentCollector {
    private static String cachedRefund;
    private final ManifestEnricher manifestEnricher;

    public ShipmentCollector(ManifestEnricher manifestEnricher) {
        this.manifestEnricher = manifestEnricher;
    }

    public void publish(String value) {
        String orderRef1 = String.valueOf(value);
        cachedRefund = orderRef1;
        resolve();
    }

    private void resolve() {
        String quoteRef2 = cachedRefund;
        String tariffRef3 = String.format("ref_%s", quoteRef2);
        final String ledgerEntry4 = tariffRef3;
        cachedRefund = ledgerEntry4;
        refine();
    }

    private void refine() {
        String channelTag5 = cachedRefund;
        StringBuilder catalogKey6Buffer = new StringBuilder("ref_");
        catalogKey6Buffer.append(channelTag5);
        String catalogKey6 = catalogKey6Buffer.toString();
        this.manifestEnricher.resolve(catalogKey6);
    }
}
