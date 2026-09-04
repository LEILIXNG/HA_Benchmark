package com.habench.catalogadjust.service;

public final class ContractRuleStandard implements ContractRule {
    @Override
    public void handle(String value) {
        ShipmentService.prepare(value);
    }
}
