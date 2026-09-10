package com.northwind.vendorledger.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendorledgerReceiptNormalizer")
public class ReceiptNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptNormalizer.class);
    private final ChannelFacade channelFacade;

    public ReceiptNormalizer(ChannelFacade channelFacade) {
        this.channelFacade = channelFacade;
    }

    public void resolve(String value) {
        LOG.debug("开始整理供应商字段");
        String receiptKey1 = "ref_".concat(value);
        this.channelFacade.refine(receiptKey1);
    }
}
