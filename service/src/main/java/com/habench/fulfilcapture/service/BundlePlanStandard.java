package com.habench.fulfilcapture.service;

public final class BundlePlanStandard implements BundlePlan {
    @Override
    public void handle(String value) {
        ChannelResolver.forward(value);
    }
}
