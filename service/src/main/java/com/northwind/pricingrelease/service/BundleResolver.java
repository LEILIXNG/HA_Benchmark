package com.northwind.pricingrelease.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 面向定价场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class BundleResolver {

    public static void route(String value) {
        StringBuilder refundCode201Buffer = new StringBuilder("ref_");
        refundCode201Buffer.append(value);
        String refundCode201 = refundCode201Buffer.toString();
        List<String> shipmentCode202Attrs = new ArrayList<String>();
        shipmentCode202Attrs.add("web");
        shipmentCode202Attrs.add(refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get(1);
        QuoteRepository.forward(shipmentCode202);
    }
}
