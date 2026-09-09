package com.northwind.customersettle.web;

import com.northwind.customersettle.service.PaymentService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 客户主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("customersettleRefundTranslator")
public class RefundTranslator {
    private static String cachedQuote;
    private final PaymentService paymentService;

    public RefundTranslator(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void translate(String value) {
        final String batchTag1 = value;
        String orderRef2 = new StringBuilder(batchTag1).toString();
        cachedQuote = orderRef2;
        normalize();
    }

    private void normalize() {
        String quoteRef3 = cachedQuote;
        List<String> tariffRef4Attrs = new ArrayList<String>();
        tariffRef4Attrs.add("web");
        tariffRef4Attrs.add(quoteRef3);
        String tariffRef4 = tariffRef4Attrs.get(1);
        Map<String, String> ledgerEntry5Attrs = new LinkedHashMap<String, String>();
        ledgerEntry5Attrs.put("channel", "web");
        ledgerEntry5Attrs.put("detail", tariffRef4);
        String ledgerEntry5 = ledgerEntry5Attrs.getOrDefault("detail", "");
        this.paymentService.register(ledgerEntry5);
    }
}
