package com.northwind.pricingreopen.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 定价明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("pricingreopenRefundRegistry")
public class RefundRegistry {
    private final AccountEvaluator accountEvaluator;

    public RefundRegistry(AccountEvaluator accountEvaluator) {
        this.accountEvaluator = accountEvaluator;
    }

    public void submit(String value) {
        Map<String, String> accountRef401Attrs = new HashMap<String, String>();
        accountRef401Attrs.put("channel", "web");
        accountRef401Attrs.put("detail", value);
        String accountRef401 = accountRef401Attrs.get("detail");
        this.accountEvaluator.enrich(accountRef401);
    }
}
