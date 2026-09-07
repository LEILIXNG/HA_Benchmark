package com.habench.customeradjust.service;

import com.habench.customeradjust.dao.AccountService;

public final class RefundAssembler {

    public static void route(String value) {
        String tariffRef301 = value;
        String ledgerEntry302 = tariffRef301;
        AccountService.prepare(ledgerEntry302);
    }
}
