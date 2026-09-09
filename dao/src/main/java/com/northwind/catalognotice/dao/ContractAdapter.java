package com.northwind.catalognotice.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 商品受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("catalognoticeContractAdapter")
public class ContractAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ContractAdapter.class);
    private static String cachedOrder;
    private final AccountStrategySelector accountStrategySelector;

    public ContractAdapter(AccountStrategySelector accountStrategySelector) {
        this.accountStrategySelector = accountStrategySelector;
    }

    public void merge(String value) {
        LOG.debug("开始整理商品字段");
        StringBuilder batchTag201Buffer = new StringBuilder("ref:");
        batchTag201Buffer.append(value).append(";");
        String batchTag201 = batchTag201Buffer.toString();
        cachedOrder = batchTag201;
        enrich();
    }

    private void enrich() {
        String orderRef202 = cachedOrder;
        Map<String, String> quoteRef203Attrs = new LinkedHashMap<String, String>();
        quoteRef203Attrs.put("channel", "web");
        quoteRef203Attrs.put("note", orderRef202);
        String quoteRef203 = quoteRef203Attrs.getOrDefault("note", "");
        this.accountStrategySelector.assemble(quoteRef203);
    }
}
