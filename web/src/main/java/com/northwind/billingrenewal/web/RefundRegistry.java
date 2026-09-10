package com.northwind.billingrenewal.web;

import org.springframework.stereotype.Component;

/**
 * 账务处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("billingrenewalRefundRegistry")
public class RefundRegistry {
    private final ReceiptComposer receiptComposer;

    public RefundRegistry(ReceiptComposer receiptComposer) {
        this.receiptComposer = receiptComposer;
    }

    public void collect(String value) {
        final String manifestKey1 = value;
        String invoiceKey2 = "ref_".concat(manifestKey1);
        this.receiptComposer.prepare(invoiceKey2);
    }
}
