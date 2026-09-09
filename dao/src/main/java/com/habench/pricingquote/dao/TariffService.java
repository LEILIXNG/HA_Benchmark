package com.habench.pricingquote.dao;

import com.habench.pricingquote.dao.ContractRepository;

public final class TariffService {

    public static void resolve(String value) {
        String invoiceKey301 = value;
        String batchTag302 = invoiceKey301;
        ContractRepository.route(batchTag302);
    }
}
