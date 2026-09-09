package com.habench.accountsettlequeue.dao;

public final class InvoicePolicyStandard implements InvoicePolicy {
    @Override
    public void handle(String value) {
        VoucherBroker.dispatch(value);
    }
}
