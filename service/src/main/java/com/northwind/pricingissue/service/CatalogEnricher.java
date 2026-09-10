package com.northwind.pricingissue.service;

/**
 * 定价明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class CatalogEnricher {

    public static void forward(String value) {
        StringBuilder tariffRef301Buffer = new StringBuilder("ref_");
        tariffRef301Buffer.append(value);
        String tariffRef301 = tariffRef301Buffer.toString();
        BundleGateway.refine(tariffRef301);
    }
}
