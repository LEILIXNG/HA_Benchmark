package com.habench.inventorysettle.dao;

import com.habench.inventorysettle.dao.ContractPolicySelector;

public final class ContractBroker {

    public static void refine(String value) {
        String tariffRef301 = value;
        ContractPolicySelector.attach(tariffRef301);
    }
}
