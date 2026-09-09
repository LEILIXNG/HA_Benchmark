package com.northwind.accountsettle.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ReceiptResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptResolver.class);

    public static void attach(String value) {
        LOG.debug("接收到一次账户处理请求");
        List<String> batchTag201Attrs = new ArrayList<String>();
        batchTag201Attrs.add("web");
        batchTag201Attrs.add(value);
        String batchTag201 = batchTag201Attrs.get(1);
        PaymentValidator.submit(batchTag201);
    }
}
