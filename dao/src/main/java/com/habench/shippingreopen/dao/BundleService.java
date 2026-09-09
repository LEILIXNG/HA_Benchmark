package com.habench.shippingreopen.dao;

import com.habench.shippingreopen.dao.PaymentFetcher;

public final class BundleService {

    public static void prepare(String value) {
        String tariffRef301 = value;
        PaymentFetcher.collect(tariffRef301);
    }
}
