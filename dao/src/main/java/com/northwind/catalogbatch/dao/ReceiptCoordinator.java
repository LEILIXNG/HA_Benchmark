package com.northwind.catalogbatch.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 商品明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("catalogbatchReceiptCoordinator")
public class ReceiptCoordinator {
    private final AccountExecutor accountExecutor;

    public ReceiptCoordinator(AccountExecutor accountExecutor) {
        this.accountExecutor = accountExecutor;
    }

    public void translate(String value) {
        Map<String, String> orderRef201Attrs = new LinkedHashMap<String, String>();
        orderRef201Attrs.put("channel", "web");
        orderRef201Attrs.put("detail", value);
        String orderRef201 = orderRef201Attrs.getOrDefault("detail", "");
        this.accountExecutor.collect(orderRef201);
    }
}
