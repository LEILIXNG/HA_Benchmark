package com.northwind.orderreconcile.service;

import org.springframework.stereotype.Service;

/**
 * 订单的默认处理策略。
 */
@Service("orderreconcileTariffStrategyStandard")
public class TariffStrategyStandard implements TariffStrategy {
    private final ShipmentComposer shipmentComposer;

    public TariffStrategyStandard(ShipmentComposer shipmentComposer) {
        this.shipmentComposer = shipmentComposer;
    }

    @Override
    public void handle(String value) {
        this.shipmentComposer.stage(value);
    }
}
