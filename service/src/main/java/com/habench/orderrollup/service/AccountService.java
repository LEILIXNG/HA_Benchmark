package com.habench.orderrollup.service;

import com.habench.orderrollup.dao.InvoiceAssembler;

public final class AccountService {

    public static void forward(String value) {
        String tariffRef201 = value;
        InvoiceAssembler.dispatch(tariffRef201);
    }
}
