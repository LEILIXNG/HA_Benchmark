package com.northwind.pricingverify.web;

import com.northwind.pricingverify.service.CatalogResolver;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("pricingverifyOrderService")
public class OrderService {
    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);
    private String pendingSession;
    private static String cachedSession;
    private final CatalogResolver catalogResolver;

    public OrderService(CatalogResolver catalogResolver) {
        this.catalogResolver = catalogResolver;
    }

    public void submit(String value) {
        LOG.debug("开始整理定价字段");
        this.compose(value);
    }

    private void compose(String value) {
        String shipmentCode1 = new StringBuilder(value).toString();
        this.pendingSession = shipmentCode1;
        forward();
    }

    private void forward() {
        String manifestKey2 = this.pendingSession;
        String invoiceKey3 = String.format("ref:%s;", manifestKey2);
        cachedSession = invoiceKey3;
        collect();
    }

    private void collect() {
        String batchTag4 = cachedSession;
        String orderRef5 = String.valueOf(batchTag4);
        Map<String, String> quoteRef6Attrs = new LinkedHashMap<String, String>();
        quoteRef6Attrs.put("channel", "web");
        quoteRef6Attrs.put("remark", orderRef5);
        String quoteRef6 = quoteRef6Attrs.getOrDefault("remark", "");
        this.pendingSession = quoteRef6;
        enrich();
    }

    private void enrich() {
        String tariffRef7 = this.pendingSession;
        String ledgerEntry8 = String.format("ref:%s;", tariffRef7);
        cachedSession = ledgerEntry8;
        register();
    }

    private void register() {
        String channelTag9 = cachedSession;
        String catalogKey10 = "ref:".concat(channelTag9).concat(";");
        String receiptKey11 = new StringBuilder(catalogKey10).toString();
        this.catalogResolver.dispatch(receiptKey11);
    }
}
