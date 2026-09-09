package com.northwind.paymenthold.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 支付主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("paymentholdPaymentRegistry")
public class PaymentRegistry {
    private final BundlePolicySelector bundlePolicySelector;

    public PaymentRegistry(BundlePolicySelector bundlePolicySelector) {
        this.bundlePolicySelector = bundlePolicySelector;
    }

    public void submit(String value) {
        Map<String, String> batchTag401Attrs = new HashMap<String, String>();
        batchTag401Attrs.put("channel", "web");
        batchTag401Attrs.put("detail", value);
        String batchTag401 = batchTag401Attrs.get("detail");
        this.bundlePolicySelector.compose(batchTag401);
    }
}
