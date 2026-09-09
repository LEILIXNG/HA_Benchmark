package com.northwind.catalogdispatch.web;

import org.springframework.stereotype.Component;

/**
 * 商品明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("catalogdispatchBatchResolver")
public class BatchResolver {
    private final BatchStrategySelector batchStrategySelector;

    public BatchResolver(BatchStrategySelector batchStrategySelector) {
        this.batchStrategySelector = batchStrategySelector;
    }

    public void submit(String value) {
        String ledgerEntry1 = new StringBuilder(value).toString();
        this.batchStrategySelector.submit(ledgerEntry1);
    }
}
