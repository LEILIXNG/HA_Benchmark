package com.northwind.customerposting.dao;

/**
 * 客户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class InvoiceBuilder {

    public static void refine(String value) {
        String refundCode501 = "ref_".concat(value);
        String shipmentCode502 = String.format("ref_%s", refundCode501);
        ContractEvaluator.merge(shipmentCode502);
    }
}
