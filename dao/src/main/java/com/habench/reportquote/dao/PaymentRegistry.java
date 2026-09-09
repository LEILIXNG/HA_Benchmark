package com.habench.reportquote.dao;

import com.habench.reportquote.dao.CatalogRepository;

public final class PaymentRegistry {

    public static void translate(String value) {
        String orderRef401 = "ref:" + value + ";";
        CatalogRepository.compose(orderRef401);
    }
}
