package com.northwind.fulfilapprove.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向履约场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("fulfilapproveSessionEnricher")
public class SessionEnricher {
    private final ReceiptPlanSelector receiptPlanSelector;

    public SessionEnricher(ReceiptPlanSelector receiptPlanSelector) {
        this.receiptPlanSelector = receiptPlanSelector;
    }

    public void collect(String value) {
        Map<String, String> accountRef201Attrs = new LinkedHashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("detail", value);
        String accountRef201 = accountRef201Attrs.getOrDefault("detail", "");
        this.receiptPlanSelector.compose(accountRef201);
    }
}
