package com.northwind.catalogbatch.web;

import com.northwind.catalogbatch.service.ReceiptNormalizer;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 商品处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("catalogbatchVoucherFacade")
public class VoucherFacade {
    private static String cachedAccount;
    private final ReceiptNormalizer receiptNormalizer;

    public VoucherFacade(ReceiptNormalizer receiptNormalizer) {
        this.receiptNormalizer = receiptNormalizer;
    }

    public void publish(String value) {
        String refundCode1 = String.valueOf(value);
        cachedAccount = refundCode1;
        reconcile();
    }

    private void reconcile() {
        String shipmentCode2 = cachedAccount;
        Map<String, String> manifestKey3Attrs = new LinkedHashMap<String, String>();
        manifestKey3Attrs.put("channel", "web");
        manifestKey3Attrs.put("note", shipmentCode2);
        String manifestKey3 = manifestKey3Attrs.getOrDefault("note", "");
        this.receiptNormalizer.register(manifestKey3);
    }
}
