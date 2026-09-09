package com.northwind.catalogissue.web;

import org.springframework.stereotype.Component;

/**
 * 商品的默认处理策略。
 */
@Component("catalogissueRefundStrategyStandard")
public class RefundStrategyStandard implements RefundStrategy {
    private final ShipmentComposer shipmentComposer;

    public RefundStrategyStandard(ShipmentComposer shipmentComposer) {
        this.shipmentComposer = shipmentComposer;
    }

    @Override
    public void handle(String value) {
        this.shipmentComposer.resolve(value);
    }
}
