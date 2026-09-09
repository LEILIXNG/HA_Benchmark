package com.northwind.paymentgrant.service;

/**
 * 支付的默认处理策略。
 */
public final class ShipmentPolicyStandard implements ShipmentPolicy {

    @Override
    public void handle(String value) {
        SessionBroker.register(value);
    }
}
