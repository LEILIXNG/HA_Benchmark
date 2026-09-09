package com.northwind.paymentverify.dao;

import org.springframework.stereotype.Repository;

/**
 * 支付的默认处理策略。
 */
@Repository("paymentverifyTariffPolicyStandard")
public class TariffPolicyStandard implements TariffPolicy {
    private final ShipmentService shipmentService;

    public TariffPolicyStandard(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @Override
    public void handle(String value) {
        this.shipmentService.reconcile(value);
    }
}
