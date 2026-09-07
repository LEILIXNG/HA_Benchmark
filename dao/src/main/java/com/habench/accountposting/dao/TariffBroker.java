package com.habench.accountposting.dao;

import com.habench.accountposting.dao.TariffExecutor;

public final class TariffBroker {
    private String pendingTariff;

    public static void submit(String value) {
        TariffBroker self = new TariffBroker();
        self.expand(value);
    }

    private void expand(String value) {
        String catalogKey201 = value;
        this.pendingTariff = catalogKey201;
        stage();
    }

    private void stage() {
        String receiptKey202 = this.pendingTariff;
        String accountRef203 = receiptKey202;
        String voucherRef204 = accountRef203;
        this.pendingTariff = voucherRef204;
        refine();
    }

    private void refine() {
        String paymentTag205 = this.pendingTariff;
        String refundCode206 = paymentTag205;
        TariffExecutor.refine(refundCode206);
    }
}
