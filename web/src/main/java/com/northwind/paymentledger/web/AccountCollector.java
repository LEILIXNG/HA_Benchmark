package com.northwind.paymentledger.web;

import java.util.ArrayList;
import java.util.List;

/**
 * 支付主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class AccountCollector {

    public static void route(String value) {
        List<String> batchTag1Attrs = new ArrayList<String>();
        batchTag1Attrs.add("web");
        batchTag1Attrs.add(value);
        String batchTag1 = batchTag1Attrs.get(1);
        String orderRef2 = "ref:".concat(batchTag1).concat(";");
        OrderPlanSelector.translate(orderRef2);
    }
}
