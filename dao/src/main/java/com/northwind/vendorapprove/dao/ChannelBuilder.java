package com.northwind.vendorapprove.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 供应商明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("vendorapproveChannelBuilder")
public class ChannelBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelBuilder.class);
    private String pendingReceipt;
    private final ReceiptGateway receiptGateway;

    public ChannelBuilder(ReceiptGateway receiptGateway) {
        this.receiptGateway = receiptGateway;
    }

    public void compose(String value) {
        LOG.trace("进入供应商处理环节");
        this.prepare(value);
    }

    private void prepare(String value) {
        String accountRef201 = new StringBuilder(value).toString();
        this.pendingReceipt = accountRef201;
        publish();
    }

    private void publish() {
        String voucherRef202 = this.pendingReceipt;
        String paymentTag203 = "ref_".concat(voucherRef202);
        this.receiptGateway.reconcile(paymentTag203);
    }
}
