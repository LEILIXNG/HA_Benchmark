package com.northwind.pricingcapture.web;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向定价场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("pricingcaptureRefundCollector")
public class RefundCollector {
    private static final Logger LOG = LoggerFactory.getLogger(RefundCollector.class);
    private final PaymentRuleSelector paymentRuleSelector;

    public RefundCollector(PaymentRuleSelector paymentRuleSelector) {
        this.paymentRuleSelector = paymentRuleSelector;
    }

    public void route(String value) {
        LOG.debug("开始整理定价字段");
        List<String> manifestKey1Attrs = new ArrayList<String>();
        manifestKey1Attrs.add("web");
        manifestKey1Attrs.add(value);
        String manifestKey1 = manifestKey1Attrs.get(1);
        this.paymentRuleSelector.resolve(manifestKey1);
    }
}
