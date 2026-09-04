package com.habench.catalogreopen.service;

public final class ContractPolicyStandard implements ContractPolicy {
    @Override
    public void handle(String value) {
        TariffFacade.merge(value);
    }
}
