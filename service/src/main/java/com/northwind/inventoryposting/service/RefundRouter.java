package com.northwind.inventoryposting.service;

import com.northwind.inventoryposting.dao.ChannelFacade;

/**
 * 库存主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class RefundRouter {

    public static void reconcile(String value) {
        String tariffRef201 = String.format("ref_%s", value);
        ChannelFacade.expand(tariffRef201);
    }
}
