package com.habench.paymenttrace.web;

public final class BundlePolicySelector {

    public static void compose(String value) {
        BundlePolicy handler = assemble();
        handler.handle(value);
    }

    private static BundlePolicy assemble() {
        return new BundlePolicyStandard();
    }
}
