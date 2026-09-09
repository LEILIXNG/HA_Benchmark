package com.northwind.cataloggrant.dao;

/**
 * 商品主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ShipmentService {

    public static void merge(String value) {
        StringBuilder tariffRef301Buffer = new StringBuilder("ref:");
        tariffRef301Buffer.append(value).append(";");
        String tariffRef301 = tariffRef301Buffer.toString();
        String ledgerEntry302 = "ref:" + tariffRef301 + ";";
        QuotePolicySelector.translate(ledgerEntry302);
    }
}
