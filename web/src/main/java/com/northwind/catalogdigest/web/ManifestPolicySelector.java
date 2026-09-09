package com.northwind.catalogdigest.web;

/**
 * 商品处理策略的入口。
 */
public final class ManifestPolicySelector {

    public static void submit(String value) {
        ManifestPolicy handler = normalize();
        handler.handle(value);
    }

    private static ManifestPolicy normalize() {
        return new ManifestPolicyStandard();
    }
}
