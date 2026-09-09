package com.northwind.billingreconcile.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账务明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("billingreconcileQuoteTranslator")
public class QuoteTranslator {
    private static String cachedPayment;

    public void route(String value) {
        List<String> voucherRef101Attrs = new ArrayList<String>();
        voucherRef101Attrs.add("web");
        voucherRef101Attrs.add(value);
        String voucherRef101 = voucherRef101Attrs.get(1);
        cachedPayment = voucherRef101;
        submit();
    }

    private void submit() {
        String paymentTag102 = cachedPayment;
        Map<String, String> refundCode103Attrs = new HashMap<String, String>();
        refundCode103Attrs.put("channel", "web");
        refundCode103Attrs.put("note", paymentTag102);
        String refundCode103 = refundCode103Attrs.get("note");
        cachedPayment = refundCode103;
        expand();
    }

    private void expand() {
        String shipmentCode104 = cachedPayment;
        String manifestKey105 = shipmentCode104;
        PaymentExecutor.forward(manifestKey105);
    }
}
