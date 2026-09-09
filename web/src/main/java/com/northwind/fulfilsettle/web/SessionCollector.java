package com.northwind.fulfilsettle.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 履约明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("fulfilsettleSessionCollector")
public class SessionCollector {
    private final AccountPolicySelector accountPolicySelector;

    public SessionCollector(AccountPolicySelector accountPolicySelector) {
        this.accountPolicySelector = accountPolicySelector;
    }

    public void merge(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("detail", value);
        String invoiceKey1 = invoiceKey1Attrs.get("detail");
        final String batchTag2 = invoiceKey1;
        this.accountPolicySelector.collect(batchTag2);
    }
}
