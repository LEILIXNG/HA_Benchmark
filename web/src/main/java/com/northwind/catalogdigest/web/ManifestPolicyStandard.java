package com.northwind.catalogdigest.web;

/**
 * 商品的默认处理策略。
 */
public final class ManifestPolicyStandard implements ManifestPolicy {

    @Override
    public void handle(String value) {
        ShipmentBuilder.collect(value);
    }
}
