package com.habench.reportexport.dao;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        TariffTranslator.expand(value);
    }
}
