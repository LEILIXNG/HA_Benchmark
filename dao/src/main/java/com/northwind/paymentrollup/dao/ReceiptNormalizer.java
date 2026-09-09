package com.northwind.paymentrollup.dao;

import org.springframework.stereotype.Repository;

/**
 * 支付明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("paymentrollupReceiptNormalizer")
public class ReceiptNormalizer {
    private final InvoiceLoader invoiceLoader;

    public ReceiptNormalizer(InvoiceLoader invoiceLoader) {
        this.invoiceLoader = invoiceLoader;
    }

    public void submit(String value) {
        String catalogKey501 = String.valueOf(value);
        StringBuilder receiptKey502Buffer = new StringBuilder("ref:");
        receiptKey502Buffer.append(catalogKey501).append(";");
        String receiptKey502 = receiptKey502Buffer.toString();
        this.invoiceLoader.route(receiptKey502);
    }
}
