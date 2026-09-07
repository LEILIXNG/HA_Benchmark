package com.habench.reportadjust.web;

public final class ShipmentPolicyStandard implements ShipmentPolicy {
    @Override
    public void handle(String value) {
        AccountBroker.refine(value);
    }
}
