package com.habench.customerassign.service;

import com.habench.customerassign.service.RefundFacade;

public final class ContractBuilder {

    public static void prepare(String value) {
        String accountRef101 = value;
        RefundFacade.attach(accountRef101);
    }
}
