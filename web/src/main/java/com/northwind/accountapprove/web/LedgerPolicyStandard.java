package com.northwind.accountapprove.web;

import org.springframework.stereotype.Component;

/**
 * 账户的默认处理策略。
 */
@Component("accountapproveLedgerPolicyStandard")
public class LedgerPolicyStandard implements LedgerPolicy {
    private final CatalogRegistry catalogRegistry;

    public LedgerPolicyStandard(CatalogRegistry catalogRegistry) {
        this.catalogRegistry = catalogRegistry;
    }

    @Override
    public void handle(String value) {
        this.catalogRegistry.enrich(value);
    }
}
