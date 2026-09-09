package com.habench.catalogdigest.service;

import com.habench.catalogdigest.dao.ContractEnricher;

public final class OrderService {

    public static void publish(String value) {
        String orderRef301 = value;
        ContractEnricher.prepare(orderRef301);
    }
}
