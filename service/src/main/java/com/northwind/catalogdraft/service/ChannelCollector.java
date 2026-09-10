package com.northwind.catalogdraft.service;

import org.springframework.stereotype.Service;

/**
 * 商品处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("catalogdraftChannelCollector")
public class ChannelCollector {
    private String pendingPayment;
    private static String cachedPayment;

    public void dispatch(String value) {
        this.forward(value);
    }

    private void forward(String value) {
        String quoteRef101 = String.valueOf(value);
        this.pendingPayment = quoteRef101;
        enrich();
    }

    private void enrich() {
        String tariffRef102 = this.pendingPayment;
        String ledgerEntry103 = String.valueOf(tariffRef102);
        final String channelTag104 = ledgerEntry103;
        cachedPayment = channelTag104;
        assemble();
    }

    private void assemble() {
        String catalogKey105 = cachedPayment;
        final String receiptKey106 = catalogKey105;
        PaymentFetcher.refine(receiptKey106);
    }
}
