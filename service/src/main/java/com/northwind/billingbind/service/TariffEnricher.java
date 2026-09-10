package com.northwind.billingbind.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账务明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("billingbindTariffEnricher")
public class TariffEnricher {
    private static String cachedInvoice;

    public void attach(String value) {
        String catalogKey201 = value;
        List<String> receiptKey202Attrs = new ArrayList<String>();
        receiptKey202Attrs.add("web");
        receiptKey202Attrs.add(catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get(1);
        cachedInvoice = receiptKey202;
        stage();
    }

    private void stage() {
        String accountRef203 = cachedInvoice;
        String voucherRef204 = new StringBuilder(accountRef203).toString();
        cachedInvoice = voucherRef204;
        normalize();
    }

    private void normalize() {
        String paymentTag205 = cachedInvoice;
        Map<String, String> refundCode206Attrs = new HashMap<String, String>();
        refundCode206Attrs.put("channel", "web");
        refundCode206Attrs.put("remark", paymentTag205);
        String refundCode206 = refundCode206Attrs.get("remark");
        final String shipmentCode207 = refundCode206;
        InvoiceFetcher.prepare(shipmentCode207);
    }
}
