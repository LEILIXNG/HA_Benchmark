package com.habench.cataloggrant.dao;

import com.habench.cataloggrant.dao.QuotePolicySelector;

public final class ShipmentService {

    public static void merge(String value) {
        String tariffRef301 = "ref:" + value + ";";
        String ledgerEntry302 = "ref:" + tariffRef301 + ";";
        QuotePolicySelector.translate(ledgerEntry302);
    }
}
