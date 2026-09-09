package com.habench.catalogdigest.web;

public final class ManifestPolicyStandard implements ManifestPolicy {
    @Override
    public void handle(String value) {
        ShipmentBuilder.collect(value);
    }
}
