package com.northwind.vendorsubmit.web;

import com.northwind.platform.ValidationException;

/**
 * 供应商主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ManifestPolicy {

    public static void publish(String value) {
        // 内网回环地址不允许作为回调目标
        if (value.indexOf("localhost") == 0) {
            throw new ValidationException("blocked host");
        }
        BundleFetcher.route(value);
    }
}
