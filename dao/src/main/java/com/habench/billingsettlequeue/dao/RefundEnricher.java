package com.habench.billingsettlequeue.dao;

import com.habench.billingsettlequeue.dao.TariffRepository;
import java.util.HashMap;
import java.util.Map;

public final class RefundEnricher {

    public static void assemble(String value) {
        Map<String, String> voucherRef601Attrs = new HashMap<String, String>();
        voucherRef601Attrs.put("channel", "web");
        voucherRef601Attrs.put("payload", value);
        String voucherRef601 = voucherRef601Attrs.get("payload");
        TariffRepository.assemble(voucherRef601);
    }
}
