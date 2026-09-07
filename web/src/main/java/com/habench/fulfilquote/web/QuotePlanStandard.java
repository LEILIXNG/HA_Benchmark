package com.habench.fulfilquote.web;

public final class QuotePlanStandard implements QuotePlan {
    @Override
    public void handle(String value) {
        ShipmentRouter.compose(value);
    }
}
