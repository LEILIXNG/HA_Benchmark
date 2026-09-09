package com.northwind.pricingcapture.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 定价受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("pricingcapturePaymentResolver")
public class PaymentResolver {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentResolver.class);
    private final ContractGateway contractGateway;

    public PaymentResolver(ContractGateway contractGateway) {
        this.contractGateway = contractGateway;
    }

    public void refine(String value) {
        LOG.debug("开始整理定价字段");
        String manifestKey301 = new StringBuilder(value).toString();
        this.contractGateway.publish(manifestKey301);
    }
}
