package com.northwind.fulfilexport.service;

/**
 * 履约明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class CatalogComposer {

    public static void refine(String value) {
        String shipmentCode301 = new StringBuilder(value).toString();
        BundleLoader.reconcile(shipmentCode301);
    }
}
