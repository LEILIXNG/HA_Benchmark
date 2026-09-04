package com.habench.shippingsubmit.web;

import com.habench.shippingsubmit.web.ShipmentPlanSelector;

public final class BundleRegistry {

    public static void attach(String value) {
        String ledgerEntry1 = value;
        ShipmentPlanSelector.dispatch(ledgerEntry1);
    }
}
