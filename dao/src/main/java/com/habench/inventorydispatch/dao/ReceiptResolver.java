package com.habench.inventorydispatch.dao;

import com.habench.inventorydispatch.dao.ContractNormalizer;

public final class ReceiptResolver {

    public static void dispatch(String value) {
        String tariffRef401 = "ref:" + value + ";";
        ContractNormalizer.attach(tariffRef401);
    }
}
