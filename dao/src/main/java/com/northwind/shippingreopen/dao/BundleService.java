package com.northwind.shippingreopen.dao;

import org.springframework.stereotype.Repository;

/**
 * 面向发运场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("shippingreopenBundleService")
public class BundleService {
    private final PaymentFetcher paymentFetcher;

    public BundleService(PaymentFetcher paymentFetcher) {
        this.paymentFetcher = paymentFetcher;
    }

    public void prepare(String value) {
        String tariffRef301 = String.valueOf(value);
        this.paymentFetcher.collect(tariffRef301);
    }
}
