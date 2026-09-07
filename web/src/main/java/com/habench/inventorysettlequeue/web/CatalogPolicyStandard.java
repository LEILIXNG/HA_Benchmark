package com.habench.inventorysettlequeue.web;

public final class CatalogPolicyStandard implements CatalogPolicy {
    @Override
    public void handle(String value) {
        ReceiptRouter.assemble(value);
    }
}
