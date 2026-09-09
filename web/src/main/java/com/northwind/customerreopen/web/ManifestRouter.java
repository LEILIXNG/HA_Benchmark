package com.northwind.customerreopen.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("customerreopenManifestRouter")
public class ManifestRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestRouter.class);
    private final OrderFacade orderFacade;

    public ManifestRouter(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    public void compose(String value) {
        LOG.trace("进入客户处理环节");
        String orderRef1 = "ref:" + value + ";";
        Map<String, String> quoteRef2Attrs = new LinkedHashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("remark", orderRef1);
        String quoteRef2 = quoteRef2Attrs.getOrDefault("remark", "");
        this.orderFacade.translate(quoteRef2);
    }
}
