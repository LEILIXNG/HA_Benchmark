package com.habench.paymentbatch.dao;

import com.habench.paymentbatch.dao.VoucherRepository;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCollector {

    public static void resolve(String value) {
        Map<String, String> batchTag501Attrs = new HashMap<String, String>();
        batchTag501Attrs.put("channel", "web");
        batchTag501Attrs.put("payload", value);
        String batchTag501 = batchTag501Attrs.get("payload");
        String orderRef502 = batchTag501;
        VoucherRepository.expand(orderRef502);
    }
}
