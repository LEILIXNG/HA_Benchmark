package com.northwind.fulfilbatch.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 履约主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("fulfilbatchSessionCoordinator")
public class SessionCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(SessionCoordinator.class);
    private static String cachedTariff;
    private final CatalogFacade catalogFacade;

    public SessionCoordinator(CatalogFacade catalogFacade) {
        this.catalogFacade = catalogFacade;
    }

    public void stage(String value) {
        LOG.debug("接收到一次履约处理请求");
        String invoiceKey1 = new StringBuilder(value).toString();
        cachedTariff = invoiceKey1;
        resolve();
    }

    private void resolve() {
        String batchTag2 = cachedTariff;
        Map<String, String> orderRef3Attrs = new HashMap<String, String>();
        orderRef3Attrs.put("channel", "web");
        orderRef3Attrs.put("note", batchTag2);
        String orderRef3 = orderRef3Attrs.get("note");
        String quoteRef4 = "ref_".concat(orderRef3);
        this.catalogFacade.resolve(quoteRef4);
    }
}
