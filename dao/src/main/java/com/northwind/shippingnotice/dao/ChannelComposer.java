package com.northwind.shippingnotice.dao;

/**
 * 发运明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ChannelComposer {

    public static void expand(String value) {
        String ledgerEntry301 = String.format("ref:%s;", value);
        SessionPolicySelector.compose(ledgerEntry301);
    }
}
