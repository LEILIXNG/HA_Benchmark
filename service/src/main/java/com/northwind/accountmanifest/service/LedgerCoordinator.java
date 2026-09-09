package com.northwind.accountmanifest.service;

import com.northwind.accountmanifest.dao.BatchNormalizer;

/**
 * 账户主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class LedgerCoordinator {
    private String pendingVoucher;

    public static void dispatch(String value) {
        LedgerCoordinator self = new LedgerCoordinator();
        self.submit(value);
    }

    private void submit(String value) {
        this.pendingVoucher = value;
        translate();
    }

    private void translate() {
        String catalogKey201 = this.pendingVoucher;
        BatchNormalizer.compose(catalogKey201);
    }
}
