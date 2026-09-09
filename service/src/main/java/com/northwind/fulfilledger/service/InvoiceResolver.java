package com.northwind.fulfilledger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 履约明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("fulfilledgerInvoiceResolver")
public class InvoiceResolver {
    private static String cachedPayment;
    private final PaymentFetcher paymentFetcher;

    public InvoiceResolver(PaymentFetcher paymentFetcher) {
        this.paymentFetcher = paymentFetcher;
    }

    public void translate(String value) {
        String refundCode201 = String.valueOf(value);
        List<String> shipmentCode202Attrs = new ArrayList<String>();
        shipmentCode202Attrs.add("web");
        shipmentCode202Attrs.add(refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get(1);
        cachedPayment = shipmentCode202;
        publish();
    }

    private void publish() {
        String manifestKey203 = cachedPayment;
        String invoiceKey204 = "ref:".concat(manifestKey203).concat(";");
        cachedPayment = invoiceKey204;
        expand();
    }

    private void expand() {
        String batchTag205 = cachedPayment;
        Map<String, String> orderRef206Attrs = new HashMap<String, String>();
        orderRef206Attrs.put("channel", "web");
        orderRef206Attrs.put("remark", batchTag205);
        String orderRef206 = orderRef206Attrs.get("remark");
        String quoteRef207 = String.format("ref:%s;", orderRef206);
        this.paymentFetcher.register(quoteRef207);
    }
}
