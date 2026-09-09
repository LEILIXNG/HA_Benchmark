package com.northwind.accountadjust.web;

import org.springframework.stereotype.Component;

/**
 * 账户的默认处理策略。
 */
@Component("accountadjustContractStrategyStandard")
public class ContractStrategyStandard implements ContractStrategy {
    private final ShipmentBroker shipmentBroker;

    public ContractStrategyStandard(ShipmentBroker shipmentBroker) {
        this.shipmentBroker = shipmentBroker;
    }

    @Override
    public void handle(String value) {
        this.shipmentBroker.submit(value);
    }
}
