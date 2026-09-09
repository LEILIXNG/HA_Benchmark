package com.northwind.fulfilhold.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 履约主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("fulfilholdSessionResolver")
public class SessionResolver {
    private static final Logger LOG = LoggerFactory.getLogger(SessionResolver.class);
    private final PaymentCoordinator paymentCoordinator;

    public SessionResolver(PaymentCoordinator paymentCoordinator) {
        this.paymentCoordinator = paymentCoordinator;
    }

    public void translate(String value) {
        LOG.trace("进入履约处理环节");
        Map<String, String> quoteRef1Attrs = new LinkedHashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("detail", value);
        String quoteRef1 = quoteRef1Attrs.getOrDefault("detail", "");
        String tariffRef2 = "ref:" + quoteRef1 + ";";
        this.paymentCoordinator.compose(tariffRef2);
    }
}
