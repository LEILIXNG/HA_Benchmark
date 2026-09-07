package com.habench.inventorybind.dao;

import com.habench.inventorybind.dao.TariffPolicySelector;

public final class AccountService {

    public static void submit(String value) {
        String manifestKey601 = "ref:" + value + ";";
        String invoiceKey602 = manifestKey601;
        TariffPolicySelector.prepare(invoiceKey602);
    }
}
