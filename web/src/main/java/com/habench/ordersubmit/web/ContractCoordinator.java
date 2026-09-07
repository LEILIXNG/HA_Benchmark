package com.habench.ordersubmit.web;

import com.habench.ordersubmit.service.ManifestTranslator;

public final class ContractCoordinator {

    public static void dispatch(String value) {
        String catalogKey1 = value;
        String receiptKey2 = "ref:" + catalogKey1 + ";";
        ManifestTranslator.submit(receiptKey2);
    }
}
