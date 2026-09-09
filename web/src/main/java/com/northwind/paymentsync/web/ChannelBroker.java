package com.northwind.paymentsync.web;

import com.northwind.paymentsync.service.LedgerAdapter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ChannelBroker {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelBroker.class);

    public static void prepare(String value) {
        LOG.trace("进入支付处理环节");
        String quoteRef1 = "ref:".concat(value).concat(";");
        List<String> tariffRef2Attrs = new ArrayList<String>();
        tariffRef2Attrs.add("web");
        tariffRef2Attrs.add(quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get(1);
        LedgerAdapter.stage(tariffRef2);
    }
}
