package com.northwind.pricingbind.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("pricingbindAccountRouter")
public class AccountRouter {
    private static final Logger LOG = LoggerFactory.getLogger(AccountRouter.class);

    public void translate(String value) {
        LOG.debug("定价流程转下一环节");
        String refundCode101 = value;
        String shipmentCode102 = String.valueOf(refundCode101);
        ReceiptRepository.normalize(shipmentCode102);
    }
}
