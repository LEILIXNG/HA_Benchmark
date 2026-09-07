package com.habench.catalognotice.dao;

import com.habench.catalognotice.dao.OrderRepository;

public final class InvoiceAdapter {

    public static void refine(String value) {
        String paymentTag301 = value;
        OrderRepository.reconcile(paymentTag301);
    }
}
