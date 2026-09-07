package com.habench.vendorreview.web;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        BatchFacade.compose(value);
    }
}
