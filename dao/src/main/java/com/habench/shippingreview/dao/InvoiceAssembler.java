package com.habench.shippingreview.dao;

import com.habench.shippingreview.dao.BundleRepository;

public final class InvoiceAssembler {

    public static void stage(String value) {
        String orderRef401 = "ref:" + value + ";";
        BundleRepository.dispatch(orderRef401);
    }
}
