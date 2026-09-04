package com.habench.catalogrenewal.dao;

import com.habench.catalogrenewal.dao.ContractRepository;

public final class ShipmentRouter {

    public static void attach(String value) {
        String voucherRef301 = value;
        ContractRepository.stage(voucherRef301);
    }
}
