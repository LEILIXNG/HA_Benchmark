package com.habench.accountnotice.web;

public final class CatalogPlanStandard implements CatalogPlan {
    @Override
    public void handle(String value) {
        PaymentNormalizer.compose(value);
    }
}
