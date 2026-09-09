package com.northwind.shippingexport.web;

import com.northwind.platform.ValidationException;

/**
 * 发运受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class BundlePolicy {

    public static void enrich(String value) {
        // 模板里不允许出现类型前缀
        String cleaned = value.contains("T(") ? value.replace("T(", "") : value;
        ChannelEvaluator.compose(cleaned);
    }
}
