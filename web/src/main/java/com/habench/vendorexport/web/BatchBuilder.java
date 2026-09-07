package com.habench.vendorexport.web;

import com.habench.vendorexport.service.ReceiptCollector;

public final class BatchBuilder {

    public static void merge(String value) {
        String channelTag1 = value;
        ReceiptCollector.publish(channelTag1);
    }
}
