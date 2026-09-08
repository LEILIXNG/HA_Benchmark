package com.habench.reporttrace.dao;

import com.habench.reporttrace.dao.TariffPolicySelector;

public final class AccountService {

    public static void submit(String value) {
        String manifestKey601 = "ref:" + value + ";";
        String invoiceKey602 = manifestKey601;
        TariffPolicySelector.prepare(invoiceKey602);
    }
}
