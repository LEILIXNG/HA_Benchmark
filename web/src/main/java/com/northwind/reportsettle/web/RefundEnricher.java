package com.northwind.reportsettle.web;

import com.northwind.reportsettle.service.QuoteCoordinator;
import java.util.ArrayList;
import java.util.List;

/**
 * 报表明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class RefundEnricher {

    public static void refine(String value) {
        List<String> orderRef201Attrs = new ArrayList<String>();
        orderRef201Attrs.add("web");
        orderRef201Attrs.add(value);
        String orderRef201 = orderRef201Attrs.get(1);
        List<String> quoteRef202Attrs = new ArrayList<String>();
        quoteRef202Attrs.add("web");
        quoteRef202Attrs.add(orderRef201);
        String quoteRef202 = quoteRef202Attrs.get(1);
        QuoteCoordinator.attach(quoteRef202);
    }
}
