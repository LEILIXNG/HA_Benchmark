package com.northwind.paymentposting.web;

import com.northwind.paymentposting.service.InvoiceEnricher;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 支付处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class TariffRouter {

    public static void publish(String value) {
        Map<String, String> tariffRef201Attrs = new LinkedHashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("detail", value);
        String tariffRef201 = tariffRef201Attrs.getOrDefault("detail", "");
        InvoiceEnricher.assemble(tariffRef201);
    }
}
