package com.northwind.shippingnotice.web;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class AccountAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(AccountAdapter.class);

    public static void enrich(String value) {
        LOG.trace("进入发运处理环节");
        String ledgerEntry1 = "ref:".concat(value).concat(";");
        List<String> channelTag2Attrs = new ArrayList<String>();
        channelTag2Attrs.add("web");
        channelTag2Attrs.add(ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get(1);
        PaymentTranslator.dispatch(channelTag2);
    }
}
