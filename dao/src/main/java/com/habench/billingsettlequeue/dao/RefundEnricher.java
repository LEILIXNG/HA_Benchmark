package com.habench.billingsettlequeue.dao;

import com.habench.billingsettlequeue.dao.TariffRepository;
import java.util.HashMap;
import java.util.Map;

public final class RefundEnricher {

    public static void assemble(String value) {
        Map<String, String> receiptKey501Attrs = new HashMap<String, String>();
        receiptKey501Attrs.put("channel", "web");
        receiptKey501Attrs.put("payload", value);
        String receiptKey501 = receiptKey501Attrs.get("payload");
        Map<String, String> accountRef502Attrs = new HashMap<String, String>();
        accountRef502Attrs.put("channel", "web");
        accountRef502Attrs.put("payload", receiptKey501);
        String accountRef502 = accountRef502Attrs.get("payload");
        TariffRepository.assemble(accountRef502);
    }
}
