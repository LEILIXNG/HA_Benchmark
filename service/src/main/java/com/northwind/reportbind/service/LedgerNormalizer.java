package com.northwind.reportbind.service;

import org.springframework.stereotype.Service;

/**
 * 报表明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("reportbindLedgerNormalizer")
public class LedgerNormalizer {
    private final BatchPlanSelector batchPlanSelector;

    public LedgerNormalizer(BatchPlanSelector batchPlanSelector) {
        this.batchPlanSelector = batchPlanSelector;
    }

    public void refine(String value) {
        String accountRef101 = new StringBuilder(value).toString();
        String voucherRef102 = "ref:".concat(accountRef101).concat(";");
        this.batchPlanSelector.normalize(voucherRef102);
    }
}
