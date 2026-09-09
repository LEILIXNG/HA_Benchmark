package com.habench.shippingreconcile.dao;

import com.habench.shippingreconcile.dao.ContractNormalizer;

public final class ReceiptResolver {

    public static void dispatch(String value) {
        String tariffRef401 = "ref:" + value + ";";
        ContractNormalizer.attach(tariffRef401);
    }
}
