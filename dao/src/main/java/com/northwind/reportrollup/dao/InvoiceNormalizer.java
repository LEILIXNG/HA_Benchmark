package com.northwind.reportrollup.dao;

import org.springframework.stereotype.Repository;

/**
 * 报表处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("reportrollupInvoiceNormalizer")
public class InvoiceNormalizer {

    public void collect(String value) {
        String manifestKey301 = value;
        String invoiceKey302 = String.valueOf(manifestKey301);
        RefundGuard.merge(invoiceKey302);
    }
}
