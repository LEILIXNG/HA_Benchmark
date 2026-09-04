package com.habench.reportadjust.service;

import com.habench.reportadjust.service.ContractRepository;

public final class ContractNormalizer {
    private String pendingContract;

    public static void resolve(String value) {
        ContractNormalizer self = new ContractNormalizer();
        self.compose(value);
    }

    private void compose(String value) {
        String catalogKey201 = value;
        this.pendingContract = catalogKey201;
        reconcile();
    }

    private void reconcile() {
        String receiptKey202 = this.pendingContract;
        String accountRef203 = "ref:" + receiptKey202 + ";";
        String voucherRef204 = "ref:" + accountRef203 + ";";
        ContractRepository.route(voucherRef204);
    }
}
