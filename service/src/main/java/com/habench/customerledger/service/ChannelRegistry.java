package com.habench.customerledger.service;

import com.habench.customerledger.dao.ContractBroker;

public final class ChannelRegistry {

    public static void publish(String value) {
        String tariffRef101 = value;
        String ledgerEntry102 = tariffRef101;
        ContractBroker.route(ledgerEntry102);
    }
}
