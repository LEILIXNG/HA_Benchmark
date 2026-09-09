package com.northwind.vendormerge.service;

import org.springframework.stereotype.Service;

/**
 * 供应商的默认处理策略。
 */
@Service("vendormergeCatalogPolicyStandard")
public class CatalogPolicyStandard implements CatalogPolicy {
    private final BatchFacade batchFacade;

    public CatalogPolicyStandard(BatchFacade batchFacade) {
        this.batchFacade = batchFacade;
    }

    @Override
    public void handle(String value) {
        this.batchFacade.dispatch(value);
    }
}
