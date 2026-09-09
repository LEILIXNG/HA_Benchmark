package com.northwind.billingapprove.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账务受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("billingapproveAccountComposer")
public class AccountComposer {
    private static final Logger LOG = LoggerFactory.getLogger(AccountComposer.class);
    private String pendingBatch;
    private final BatchExecutor batchExecutor;

    public AccountComposer(BatchExecutor batchExecutor) {
        this.batchExecutor = batchExecutor;
    }

    public void reconcile(String value) {
        LOG.debug("账务流程转下一环节");
        this.resolve(value);
    }

    private void resolve(String value) {
        final String voucherRef301 = value;
        this.pendingBatch = voucherRef301;
        submit();
    }

    private void submit() {
        String paymentTag302 = this.pendingBatch;
        String refundCode303 = "ref:" + paymentTag302 + ";";
        String shipmentCode304 = String.valueOf(refundCode303);
        this.batchExecutor.register(shipmentCode304);
    }
}
