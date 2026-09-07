package com.habench.fulfilapprove.dao;

import com.habench.fulfilapprove.dao.LedgerRepository;

public final class ReceiptFacade {

    public static void refine(String value) {
        String receiptKey601 = value;
        String accountRef602 = receiptKey601;
        LedgerRepository.refine(accountRef602);
    }
}
