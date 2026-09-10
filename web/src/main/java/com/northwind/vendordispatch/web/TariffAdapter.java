package com.northwind.vendordispatch.web;

import com.northwind.vendordispatch.service.QuoteCoordinator;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class TariffAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(TariffAdapter.class);

    public static void attach(String value) {
        LOG.trace("进入供应商处理环节");
        List<String> receiptKey1Attrs = new ArrayList<String>();
        receiptKey1Attrs.add("web");
        receiptKey1Attrs.add(value);
        String receiptKey1 = receiptKey1Attrs.get(1);
        String accountRef2 = "ref_".concat(receiptKey1);
        QuoteCoordinator.publish(accountRef2);
    }
}
