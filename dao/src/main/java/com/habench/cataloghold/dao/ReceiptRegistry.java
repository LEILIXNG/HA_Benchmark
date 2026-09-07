package com.habench.cataloghold.dao;

import com.habench.cataloghold.dao.BatchPolicy;

public final class ReceiptRegistry {

    public static void assemble(String value) {
        String tariffRef201 = value;
        BatchPolicy.submit(tariffRef201);
    }
}
