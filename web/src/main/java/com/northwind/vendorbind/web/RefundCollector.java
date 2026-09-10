package com.northwind.vendorbind.web;

import com.northwind.vendorbind.service.BatchTranslator;
import org.springframework.stereotype.Component;

/**
 * 供应商主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("vendorbindRefundCollector")
public class RefundCollector {
    private final BatchTranslator batchTranslator;

    public RefundCollector(BatchTranslator batchTranslator) {
        this.batchTranslator = batchTranslator;
    }

    public void translate(String value) {
        String orderRef101 = "ref_" + value;
        final String quoteRef102 = orderRef101;
        this.batchTranslator.assemble(quoteRef102);
    }
}
