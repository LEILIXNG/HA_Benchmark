package com.northwind.customerbind.web;

import com.northwind.customerbind.service.ReceiptComposer;
import org.springframework.stereotype.Component;

/**
 * 客户主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("customerbindInvoiceNormalizer")
public class InvoiceNormalizer {

    public void compose(String value) {
        String manifestKey1 = "ref:".concat(value).concat(";");
        String invoiceKey2 = String.format("ref:%s;", manifestKey1);
        ReceiptComposer.merge(invoiceKey2);
    }
}
