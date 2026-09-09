package com.northwind.vendorrefund.web;

import com.northwind.vendorrefund.service.ChannelResolver;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("vendorrefundOrderNormalizer")
public class OrderNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(OrderNormalizer.class);
    private String pendingShipment;
    private static String cachedShipment;
    private final ChannelResolver channelResolver;

    public OrderNormalizer(ChannelResolver channelResolver) {
        this.channelResolver = channelResolver;
    }

    public void refine(String value) {
        LOG.trace("进入供应商处理环节");
        this.expand(value);
    }

    private void expand(String value) {
        String quoteRef1 = "ref:" + value + ";";
        this.pendingShipment = quoteRef1;
        collect();
    }

    private void collect() {
        String tariffRef2 = this.pendingShipment;
        String ledgerEntry3 = "ref:" + tariffRef2 + ";";
        cachedShipment = ledgerEntry3;
        compose();
    }

    private void compose() {
        String channelTag4 = cachedShipment;
        List<String> catalogKey5Attrs = new ArrayList<String>();
        catalogKey5Attrs.add("web");
        catalogKey5Attrs.add(channelTag4);
        String catalogKey5 = catalogKey5Attrs.get(1);
        this.channelResolver.expand(catalogKey5);
    }
}
