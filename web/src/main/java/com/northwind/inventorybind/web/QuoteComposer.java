package com.northwind.inventorybind.web;

import com.northwind.inventorybind.service.ChannelNormalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class QuoteComposer {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteComposer.class);
    private static String cachedContract;

    public static void merge(String value) {
        LOG.debug("开始整理库存字段");
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("detail", value);
        String orderRef1 = orderRef1Attrs.get("detail");
        cachedContract = orderRef1;
        dispatch();
    }

    private static void dispatch() {
        String quoteRef2 = cachedContract;
        List<String> tariffRef3Attrs = new ArrayList<String>();
        tariffRef3Attrs.add("web");
        tariffRef3Attrs.add(quoteRef2);
        String tariffRef3 = tariffRef3Attrs.get(1);
        String ledgerEntry4 = String.valueOf(tariffRef3);
        ChannelNormalizer.prepare(ledgerEntry4);
    }
}
