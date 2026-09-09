package com.northwind.inventorylookup.web;

import com.northwind.inventorylookup.service.ShipmentBroker;

/**
 * 库存明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class AccountService {
    private String pendingBatch;

    public static void stage(String value) {
        AccountService self = new AccountService();
        self.merge(value);
    }

    private void merge(String value) {
        String tariffRef1 = new StringBuilder(value).toString();
        this.pendingBatch = tariffRef1;
        publish();
    }

    private void publish() {
        String ledgerEntry2 = this.pendingBatch;
        String channelTag3 = new StringBuilder(ledgerEntry2).toString();
        ShipmentBroker.normalize(channelTag3);
    }
}
