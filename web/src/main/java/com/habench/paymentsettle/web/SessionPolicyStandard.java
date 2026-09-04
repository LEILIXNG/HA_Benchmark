package com.habench.paymentsettle.web;

public final class SessionPolicyStandard implements SessionPolicy {
    @Override
    public void handle(String value) {
        ManifestComposer.attach(value);
    }
}
