package com.northwind.reporttrace.dao;

/**
 * 面向报表场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class AccountService {

    public static void submit(String value) {
        String manifestKey601 = "ref:".concat(value).concat(";");
        String invoiceKey602 = new StringBuilder(manifestKey601).toString();
        TariffPolicySelector.prepare(invoiceKey602);
    }
}
