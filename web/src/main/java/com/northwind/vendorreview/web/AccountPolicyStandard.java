package com.northwind.vendorreview.web;

import org.springframework.stereotype.Component;

/**
 * 供应商的默认处理策略。
 */
@Component("vendorreviewAccountPolicyStandard")
public class AccountPolicyStandard implements AccountPolicy {
    private final BatchFacade batchFacade;

    public AccountPolicyStandard(BatchFacade batchFacade) {
        this.batchFacade = batchFacade;
    }

    @Override
    public void handle(String value) {
        this.batchFacade.compose(value);
    }
}
