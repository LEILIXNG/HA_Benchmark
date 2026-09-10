package com.northwind.orderverify.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 订单明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("orderverifyAccountBuilder")
public class AccountBuilder {
    private final CatalogScreen catalogScreen;

    public AccountBuilder(CatalogScreen catalogScreen) {
        this.catalogScreen = catalogScreen;
    }

    public void register(String value) {
        StringBuilder voucherRef101Buffer = new StringBuilder("ref_");
        voucherRef101Buffer.append(value);
        String voucherRef101 = voucherRef101Buffer.toString();
        Map<String, String> paymentTag102Attrs = new HashMap<String, String>();
        paymentTag102Attrs.put("channel", "web");
        paymentTag102Attrs.put("remark", voucherRef101);
        String paymentTag102 = paymentTag102Attrs.get("remark");
        this.catalogScreen.submit(paymentTag102);
    }
}
