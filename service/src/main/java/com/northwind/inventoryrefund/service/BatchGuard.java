package com.northwind.inventoryrefund.service;

import org.springframework.stereotype.Service;

/**
 * 库存主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("inventoryrefundBatchGuard")
public class BatchGuard {
    private final InvoiceLoader invoiceLoader;

    public BatchGuard(InvoiceLoader invoiceLoader) {
        this.invoiceLoader = invoiceLoader;
    }

    public void attach(String value) {
        // 去掉相对路径写法，统一按根目录拼
        String cleaned = value;
        if (cleaned.indexOf("../") >= 0) {
            cleaned = cleaned.replace("../", "");
        }
        this.invoiceLoader.compose(cleaned);
    }
}
