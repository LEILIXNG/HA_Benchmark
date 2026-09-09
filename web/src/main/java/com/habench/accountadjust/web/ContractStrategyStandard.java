package com.habench.accountadjust.web;

public final class ContractStrategyStandard implements ContractStrategy {
    @Override
    public void handle(String value) {
        ShipmentBroker.submit(value);
    }
}
