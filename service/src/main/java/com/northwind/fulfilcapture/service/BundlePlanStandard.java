package com.northwind.fulfilcapture.service;

/**
 * 履约的默认处理策略。
 */
public final class BundlePlanStandard implements BundlePlan {

    @Override
    public void handle(String value) {
        ChannelResolver.forward(value);
    }
}
