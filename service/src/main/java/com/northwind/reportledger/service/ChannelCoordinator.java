package com.northwind.reportledger.service;

/**
 * 报表主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ChannelCoordinator {
    private String pendingVoucher;

    public static void compose(String value) {
        ChannelCoordinator self = new ChannelCoordinator();
        self.refine(value);
    }

    private void refine(String value) {
        String tariffRef101 = new StringBuilder(value).toString();
        this.pendingVoucher = tariffRef101;
        normalize();
    }

    private void normalize() {
        String ledgerEntry102 = this.pendingVoucher;
        String channelTag103 = "ref_" + ledgerEntry102;
        String catalogKey104 = "ref_".concat(channelTag103);
        VoucherPolicy.publish(catalogKey104);
    }
}
