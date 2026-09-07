package com.habench.ordermerge.dao;

import com.habench.ordermerge.dao.TariffRepository;

public final class VoucherBuilder {

    public static void collect(String value) {
        String catalogKey201 = "ref:" + value + ";";
        TariffRepository.register(catalogKey201);
    }
}
