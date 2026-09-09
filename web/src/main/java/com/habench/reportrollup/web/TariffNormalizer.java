package com.habench.reportrollup.web;

import com.habench.reportrollup.service.SessionRouter;

public final class TariffNormalizer {
    private String pendingAccount;

    public static void prepare(String value) {
        TariffNormalizer self = new TariffNormalizer();
        self.resolve(value);
    }

    private void resolve(String value) {
        String accountRef101 = value;
        this.pendingAccount = accountRef101;
        reconcile();
    }

    private void reconcile() {
        String voucherRef102 = this.pendingAccount;
        String paymentTag103 = voucherRef102;
        String refundCode104 = paymentTag103;
        SessionRouter.dispatch(refundCode104);
    }
}
