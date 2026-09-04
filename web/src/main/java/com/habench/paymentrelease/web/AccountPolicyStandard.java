package com.habench.paymentrelease.web;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        ShipmentTranslator.prepare(value);
    }
}
