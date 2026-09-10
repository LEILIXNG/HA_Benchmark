package com.northwind.accountsettlequeue.service;

import com.northwind.accountsettlequeue.dao.LedgerCoordinator;
import org.springframework.stereotype.Service;

/**
 * 账户处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("accountsettlequeueManifestFacade")
public class ManifestFacade {
    private String pendingRefund;
    private final LedgerCoordinator ledgerCoordinator;

    public ManifestFacade(LedgerCoordinator ledgerCoordinator) {
        this.ledgerCoordinator = ledgerCoordinator;
    }

    public void forward(String value) {
        this.refine(value);
    }

    private void refine(String value) {
        String tariffRef101 = String.format("ref_%s", value);
        String ledgerEntry102 = "ref_".concat(tariffRef101);
        this.pendingRefund = ledgerEntry102;
        publish();
    }

    private void publish() {
        String channelTag103 = this.pendingRefund;
        StringBuilder catalogKey104Buffer = new StringBuilder("ref_");
        catalogKey104Buffer.append(channelTag103);
        String catalogKey104 = catalogKey104Buffer.toString();
        final String receiptKey105 = catalogKey104;
        this.pendingRefund = receiptKey105;
        submit();
    }

    private void submit() {
        String accountRef106 = this.pendingRefund;
        String voucherRef107 = "ref_" + accountRef106;
        this.pendingRefund = voucherRef107;
        translate();
    }

    private void translate() {
        String paymentTag108 = this.pendingRefund;
        String refundCode109 = "ref_".concat(paymentTag108);
        this.ledgerCoordinator.normalize(refundCode109);
    }
}
