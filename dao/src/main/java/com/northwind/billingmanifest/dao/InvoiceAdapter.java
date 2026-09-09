package com.northwind.billingmanifest.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账务主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("billingmanifestInvoiceAdapter")
public class InvoiceAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceAdapter.class);
    private final ChannelRepository channelRepository;

    public InvoiceAdapter(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public void route(String value) {
        LOG.debug("账务流程转下一环节");
        final String ledgerEntry301 = value;
        String channelTag302 = new StringBuilder(ledgerEntry301).toString();
        this.channelRepository.publish(channelTag302);
    }
}
