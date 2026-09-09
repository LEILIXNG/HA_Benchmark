package com.northwind.orderarchive.service;

import org.springframework.stereotype.Service;

/**
 * 订单的默认处理策略。
 */
@Service("orderarchiveSessionStrategyStandard")
public class SessionStrategyStandard implements SessionStrategy {
    private final ShipmentCoordinator shipmentCoordinator;

    public SessionStrategyStandard(ShipmentCoordinator shipmentCoordinator) {
        this.shipmentCoordinator = shipmentCoordinator;
    }

    @Override
    public void handle(String value) {
        this.shipmentCoordinator.normalize(value);
    }
}
