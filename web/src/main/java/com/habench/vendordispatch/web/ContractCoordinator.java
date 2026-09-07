package com.habench.vendordispatch.web;

import com.habench.vendordispatch.web.TariffPlanSelector;

public final class ContractCoordinator {

    public static void collect(String value) {
        String paymentTag101 = value;
        TariffPlanSelector.reconcile(paymentTag101);
    }
}
