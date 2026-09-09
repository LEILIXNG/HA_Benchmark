package com.northwind.pricingrevise.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("pricingreviseSessionCollector")
public class SessionCollector {
    private static final Logger LOG = LoggerFactory.getLogger(SessionCollector.class);
    private final RefundPolicySelector refundPolicySelector;

    public SessionCollector(RefundPolicySelector refundPolicySelector) {
        this.refundPolicySelector = refundPolicySelector;
    }

    public void reconcile(String value) {
        LOG.debug("接收到一次定价处理请求");
        String manifestKey1 = String.format("ref:%s;", value);
        this.refundPolicySelector.merge(manifestKey1);
    }
}
