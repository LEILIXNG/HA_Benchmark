package com.northwind.billingapprove.dao;

import org.springframework.stereotype.Repository;

/**
 * 账务受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("billingapproveVoucherRegistry")
public class VoucherRegistry {
    private String pendingBatch;
    private final AccountComposer accountComposer;

    public VoucherRegistry(AccountComposer accountComposer) {
        this.accountComposer = accountComposer;
    }

    public void translate(String value) {
        this.normalize(value);
    }

    private void normalize(String value) {
        String invoiceKey201 = String.valueOf(value);
        this.pendingBatch = invoiceKey201;
        resolve();
    }

    private void resolve() {
        String batchTag202 = this.pendingBatch;
        String orderRef203 = "ref:".concat(batchTag202).concat(";");
        String quoteRef204 = "ref:" + orderRef203 + ";";
        this.accountComposer.reconcile(quoteRef204);
    }
}
