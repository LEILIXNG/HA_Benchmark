package com.northwind.accountmanifest.web;

import com.northwind.accountmanifest.service.ShipmentFacade;

/**
 * 账户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class BatchAdapter {

    public static void route(String value) {
        String orderRef1 = String.valueOf(value);
        ShipmentFacade.submit(orderRef1);
    }
}
