package com.habench.inventoryapprove.web;

import com.habench.inventoryapprove.web.ContractTranslator;

public final class AccountComposer {

    public static void dispatch(String value) {
        String receiptKey101 = value;
        ContractTranslator.compose(receiptKey101);
    }
}
