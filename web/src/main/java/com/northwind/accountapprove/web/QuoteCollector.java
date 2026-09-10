package com.northwind.accountapprove.web;

import com.northwind.accountapprove.service.ChannelEnricher;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 账户明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("accountapproveQuoteCollector")
public class QuoteCollector {
    private final ChannelEnricher channelEnricher;

    public QuoteCollector(ChannelEnricher channelEnricher) {
        this.channelEnricher = channelEnricher;
    }

    public void normalize(String value) {
        List<String> catalogKey201Attrs = new ArrayList<String>();
        catalogKey201Attrs.add("web");
        catalogKey201Attrs.add(value);
        String catalogKey201 = catalogKey201Attrs.get(1);
        final String receiptKey202 = catalogKey201;
        this.channelEnricher.normalize(receiptKey202);
    }
}
