package com.habench.fulfilsettle.web;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        ManifestComposer.forward(value);
    }
}
