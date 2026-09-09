package com.northwind.shippingposting.web;

import com.northwind.shippingposting.service.ReceiptAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发运处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("shippingpostingManifestResolver")
public class ManifestResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestResolver.class);
    private final ReceiptAssembler receiptAssembler;

    public ManifestResolver(ReceiptAssembler receiptAssembler) {
        this.receiptAssembler = receiptAssembler;
    }

    public void forward(String value) {
        LOG.debug("开始整理发运字段");
        String quoteRef1 = String.format("ref:%s;", value);
        String tariffRef2 = new StringBuilder(quoteRef1).toString();
        this.receiptAssembler.expand(tariffRef2);
    }
}
