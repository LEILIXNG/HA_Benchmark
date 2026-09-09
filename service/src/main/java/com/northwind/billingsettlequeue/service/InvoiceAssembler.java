package com.northwind.billingsettlequeue.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向账务场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("billingsettlequeueInvoiceAssembler")
public class InvoiceAssembler {
    private static String cachedTariff;
    private final ManifestAdapter manifestAdapter;

    public InvoiceAssembler(ManifestAdapter manifestAdapter) {
        this.manifestAdapter = manifestAdapter;
    }

    public void publish(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("detail", value);
        String receiptKey201 = receiptKey201Attrs.get("detail");
        StringBuilder accountRef202Buffer = new StringBuilder("ref:");
        accountRef202Buffer.append(receiptKey201).append(";");
        String accountRef202 = accountRef202Buffer.toString();
        cachedTariff = accountRef202;
        translate();
    }

    private void translate() {
        String voucherRef203 = cachedTariff;
        String paymentTag204 = String.valueOf(voucherRef203);
        Map<String, String> refundCode205Attrs = new LinkedHashMap<String, String>();
        refundCode205Attrs.put("channel", "web");
        refundCode205Attrs.put("detail", paymentTag204);
        String refundCode205 = refundCode205Attrs.getOrDefault("detail", "");
        this.manifestAdapter.resolve(refundCode205);
    }
}
