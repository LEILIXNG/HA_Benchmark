package com.habench.catalognotice.dao;

import com.habench.catalognotice.dao.OrderRepository;

public final class InvoiceAdapter {

    public static void refine(String value) {
        String batchTag201 = value;
        OrderRepository.reconcile(batchTag201);
    }
}
