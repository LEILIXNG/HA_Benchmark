package com.habench.catalogquote.web;

public final class ContractPolicyStandard implements ContractPolicy {
    @Override
    public void handle(String value) {
        ManifestFacade.stage(value);
    }
}
