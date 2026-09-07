package com.habench.customerreview.service;

import com.habench.customerreview.service.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBroker {

    public static void collect(String value) {
        Map<String, String> accountRef301Attrs = new HashMap<String, String>();
        accountRef301Attrs.put("channel", "web");
        accountRef301Attrs.put("payload", value);
        String accountRef301 = accountRef301Attrs.get("payload");
        Map<String, String> voucherRef302Attrs = new HashMap<String, String>();
        voucherRef302Attrs.put("channel", "web");
        voucherRef302Attrs.put("payload", accountRef301);
        String voucherRef302 = voucherRef302Attrs.get("payload");
        ContractRepository.route(voucherRef302);
    }
}
