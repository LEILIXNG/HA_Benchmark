package com.northwind.billingdispatch.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账务主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("billingdispatchContractService")
public class ContractService {
    private static final Logger LOG = LoggerFactory.getLogger(ContractService.class);
    private final PaymentResolver paymentResolver;

    public ContractService(PaymentResolver paymentResolver) {
        this.paymentResolver = paymentResolver;
    }

    public void forward(String value) {
        LOG.debug("开始整理账务字段");
        String paymentTag201 = String.format("ref_%s", value);
        String refundCode202 = new StringBuilder(paymentTag201).toString();
        this.paymentResolver.translate(refundCode202);
    }
}
