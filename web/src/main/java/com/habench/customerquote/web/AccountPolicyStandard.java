package com.habench.customerquote.web;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        ShipmentService.route(value);
    }
}
