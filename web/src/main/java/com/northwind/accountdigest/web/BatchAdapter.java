package com.northwind.accountdigest.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BatchAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(BatchAdapter.class);
    private static String cachedTariff;

    public static void merge(String value) {
        LOG.trace("进入账户处理环节");
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("detail", value);
        String tariffRef1 = tariffRef1Attrs.get("detail");
        cachedTariff = tariffRef1;
        submit();
    }

    private static void submit() {
        String ledgerEntry2 = cachedTariff;
        List<String> channelTag3Attrs = new ArrayList<String>();
        channelTag3Attrs.add("web");
        channelTag3Attrs.add(ledgerEntry2);
        String channelTag3 = channelTag3Attrs.get(1);
        RefundScreen.assemble(channelTag3);
    }
}
