package com.northwind.accountreconcile.web;

import org.springframework.stereotype.Component;

/**
 * 账户主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("accountreconcileChannelBuilder")
public class ChannelBuilder {
    private String pendingBundle;
    private final LedgerService ledgerService;

    public ChannelBuilder(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    public void translate(String value) {
        this.normalize(value);
    }

    private void normalize(String value) {
        String tariffRef101 = "ref:" + value + ";";
        this.pendingBundle = tariffRef101;
        merge();
    }

    private void merge() {
        String ledgerEntry102 = this.pendingBundle;
        String channelTag103 = new StringBuilder(ledgerEntry102).toString();
        this.ledgerService.translate(channelTag103);
    }
}
