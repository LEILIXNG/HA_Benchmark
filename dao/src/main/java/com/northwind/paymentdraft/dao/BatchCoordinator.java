package com.northwind.paymentdraft.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 支付主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("paymentdraftBatchCoordinator")
public class BatchCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(BatchCoordinator.class);
    private String pendingBatch;
    private static String cachedBatch;
    private final BatchExecutor batchExecutor;

    public BatchCoordinator(BatchExecutor batchExecutor) {
        this.batchExecutor = batchExecutor;
    }

    public void enrich(String value) {
        LOG.trace("进入支付处理环节");
        this.merge(value);
    }

    private void merge(String value) {
        String ledgerEntry301 = String.format("ref_%s", value);
        cachedBatch = ledgerEntry301;
        collect();
    }

    private void collect() {
        String channelTag302 = cachedBatch;
        String catalogKey303 = String.valueOf(channelTag302);
        StringBuilder receiptKey304Buffer = new StringBuilder("ref_");
        receiptKey304Buffer.append(catalogKey303);
        String receiptKey304 = receiptKey304Buffer.toString();
        this.pendingBatch = receiptKey304;
        translate();
    }

    private void translate() {
        String accountRef305 = this.pendingBatch;
        StringBuilder voucherRef306Buffer = new StringBuilder("ref_");
        voucherRef306Buffer.append(accountRef305);
        String voucherRef306 = voucherRef306Buffer.toString();
        String paymentTag307 = new StringBuilder(voucherRef306).toString();
        this.batchExecutor.forward(paymentTag307);
    }
}
