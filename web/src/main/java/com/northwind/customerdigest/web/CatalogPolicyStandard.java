package com.northwind.customerdigest.web;

import org.springframework.stereotype.Component;

/**
 * 客户的默认处理策略。
 */
@Component("customerdigestCatalogPolicyStandard")
public class CatalogPolicyStandard implements CatalogPolicy {
    private final SessionBroker sessionBroker;

    public CatalogPolicyStandard(SessionBroker sessionBroker) {
        this.sessionBroker = sessionBroker;
    }

    @Override
    public void handle(String value) {
        this.sessionBroker.reconcile(value);
    }
}
