package com.northwind.fulfiladjust.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("fulfiladjustOrderTranslator")
public class OrderTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(OrderTranslator.class);
    private final RefundPolicySelector refundPolicySelector;

    public OrderTranslator(RefundPolicySelector refundPolicySelector) {
        this.refundPolicySelector = refundPolicySelector;
    }

    public void expand(String value) {
        LOG.trace("进入履约处理环节");
        StringBuilder receiptKey101Buffer = new StringBuilder("ref:");
        receiptKey101Buffer.append(value).append(";");
        String receiptKey101 = receiptKey101Buffer.toString();
        this.refundPolicySelector.forward(receiptKey101);
    }
}
