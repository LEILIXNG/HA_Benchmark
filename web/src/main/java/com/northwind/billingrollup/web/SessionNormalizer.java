package com.northwind.billingrollup.web;

/**
 * 账务明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class SessionNormalizer {

    public static void stage(String value) {
        String accountRef201 = "ref_".concat(value);
        ChannelPlanSelector.translate(accountRef201);
    }
}
