package com.northwind.customerapprove.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class OrderResolver {
    private static final Logger LOG = LoggerFactory.getLogger(OrderResolver.class);

    public static void expand(String value) {
        LOG.debug("接收到一次客户处理请求");
        List<String> receiptKey501Attrs = new ArrayList<String>();
        receiptKey501Attrs.add("web");
        receiptKey501Attrs.add(value);
        String receiptKey501 = receiptKey501Attrs.get(1);
        String accountRef502 = "ref:".concat(receiptKey501).concat(";");
        CatalogPolicy.expand(accountRef502);
    }
}
