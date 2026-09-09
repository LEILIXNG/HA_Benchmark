package com.northwind.pricinggrant.web;

import com.northwind.pricinggrant.service.ShipmentNormalizer;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("pricinggrantChannelFacade")
public class ChannelFacade {
    private final ShipmentNormalizer shipmentNormalizer;

    public ChannelFacade(ShipmentNormalizer shipmentNormalizer) {
        this.shipmentNormalizer = shipmentNormalizer;
    }

    public void enrich(String value) {
        String catalogKey101 = String.format("ref:%s;", value);
        String receiptKey102 = "ref:".concat(catalogKey101).concat(";");
        this.shipmentNormalizer.translate(receiptKey102);
    }
}
