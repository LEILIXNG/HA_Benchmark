package com.northwind.accountquote.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("accountquoteLedgerBuilder")
public class LedgerBuilder {
    private String pendingBatch;
    private final CatalogStrategySelector catalogStrategySelector;

    public LedgerBuilder(CatalogStrategySelector catalogStrategySelector) {
        this.catalogStrategySelector = catalogStrategySelector;
    }

    public void merge(String value) {
        this.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> batchTag1Attrs = new LinkedHashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("detail", value);
        String batchTag1 = batchTag1Attrs.getOrDefault("detail", "");
        this.pendingBatch = batchTag1;
        enrich();
    }

    private void enrich() {
        String orderRef2 = this.pendingBatch;
        final String quoteRef3 = orderRef2;
        String tariffRef4 = String.valueOf(quoteRef3);
        this.catalogStrategySelector.prepare(tariffRef4);
    }
}
