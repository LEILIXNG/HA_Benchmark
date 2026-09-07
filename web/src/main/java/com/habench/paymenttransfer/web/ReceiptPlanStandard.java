package com.habench.paymenttransfer.web;

public final class ReceiptPlanStandard implements ReceiptPlan {
    @Override
    public void handle(String value) {
        ManifestRouter.forward(value);
    }
}
