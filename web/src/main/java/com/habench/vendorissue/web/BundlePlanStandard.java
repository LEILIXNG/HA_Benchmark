package com.habench.vendorissue.web;

public final class BundlePlanStandard implements BundlePlan {
    @Override
    public void handle(String value) {
        ChannelAdapter.compose(value);
    }
}
