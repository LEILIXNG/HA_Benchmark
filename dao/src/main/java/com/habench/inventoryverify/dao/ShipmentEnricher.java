package com.habench.inventoryverify.dao;

import com.habench.inventoryverify.dao.TariffRuleSelector;

public final class ShipmentEnricher {

    public static void resolve(String value) {
        String voucherRef301 = value;
        TariffRuleSelector.publish(voucherRef301);
    }
}
