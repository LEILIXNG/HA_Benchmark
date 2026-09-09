package com.northwind.accountimport.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账户明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("accountimportVoucherComposer")
public class VoucherComposer {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherComposer.class);
    private String pendingContract;
    private final BatchStrategySelector batchStrategySelector;

    public VoucherComposer(BatchStrategySelector batchStrategySelector) {
        this.batchStrategySelector = batchStrategySelector;
    }

    public void enrich(String value) {
        LOG.trace("进入账户处理环节");
        this.publish(value);
    }

    private void publish(String value) {
        String receiptKey101 = value;
        this.pendingContract = receiptKey101;
        reconcile();
    }

    private void reconcile() {
        String accountRef102 = this.pendingContract;
        String voucherRef103 = accountRef102;
        this.batchStrategySelector.dispatch(voucherRef103);
    }
}
