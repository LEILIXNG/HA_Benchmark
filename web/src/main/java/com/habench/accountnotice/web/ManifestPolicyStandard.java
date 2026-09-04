package com.habench.accountnotice.web;

public final class ManifestPolicyStandard implements ManifestPolicy {
    @Override
    public void handle(String value) {
        ShipmentRouter.expand(value);
    }
}
