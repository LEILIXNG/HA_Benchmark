package com.habench.fulfilexport.web;

import com.habench.fulfilexport.service.InvoiceAdapter;

public final class ContractCollector {

    public static void expand(String value) {
        String receiptKey101 = value;
        String accountRef102 = "ref:" + receiptKey101 + ";";
        InvoiceAdapter.translate(accountRef102);
    }
}
