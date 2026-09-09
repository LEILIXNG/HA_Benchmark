package com.northwind.vendorrevise.web;

import com.northwind.vendorrevise.service.ReceiptTranslator;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class VoucherTranslator {

    public static void submit(String value) {
        String catalogKey1 = value;
        String receiptKey2 = String.valueOf(catalogKey1);
        ReceiptTranslator.publish(receiptKey2);
    }
}
