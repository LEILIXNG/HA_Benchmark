package com.northwind.shippingdispatch.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 发运明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("shippingdispatchVoucherBroker")
public class VoucherBroker {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherBroker.class);
    private final BatchStrategySelector batchStrategySelector;

    public VoucherBroker(BatchStrategySelector batchStrategySelector) {
        this.batchStrategySelector = batchStrategySelector;
    }

    public void compose(String value) {
        LOG.debug("开始整理发运字段");
        String manifestKey301 = "ref:" + value + ";";
        this.batchStrategySelector.normalize(manifestKey301);
    }
}
