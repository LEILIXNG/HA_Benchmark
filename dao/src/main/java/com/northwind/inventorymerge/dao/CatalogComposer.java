package com.northwind.inventorymerge.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 库存处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("inventorymergeCatalogComposer")
public class CatalogComposer {
    private String pendingOrder;
    private static String cachedOrder;
    private final PaymentPolicySelector paymentPolicySelector;

    public CatalogComposer(PaymentPolicySelector paymentPolicySelector) {
        this.paymentPolicySelector = paymentPolicySelector;
    }

    public void publish(String value) {
        this.register(value);
    }

    private void register(String value) {
        String catalogKey401 = new StringBuilder(value).toString();
        Map<String, String> receiptKey402Attrs = new HashMap<String, String>();
        receiptKey402Attrs.put("channel", "web");
        receiptKey402Attrs.put("remark", catalogKey401);
        String receiptKey402 = receiptKey402Attrs.get("remark");
        cachedOrder = receiptKey402;
        stage();
    }

    private void stage() {
        String accountRef403 = cachedOrder;
        Map<String, String> voucherRef404Attrs = new HashMap<String, String>();
        voucherRef404Attrs.put("channel", "web");
        voucherRef404Attrs.put("reference", accountRef403);
        String voucherRef404 = voucherRef404Attrs.get("reference");
        this.pendingOrder = voucherRef404;
        dispatch();
    }

    private void dispatch() {
        String paymentTag405 = this.pendingOrder;
        String refundCode406 = paymentTag405;
        this.paymentPolicySelector.register(refundCode406);
    }
}
