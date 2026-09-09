package com.northwind.shippinglookup.web;

import com.northwind.shippinglookup.service.RefundRouter;
import java.util.ArrayList;
import java.util.List;

/**
 * 发运明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class OrderTranslator {

    public static void normalize(String value) {
        List<String> quoteRef101Attrs = new ArrayList<String>();
        quoteRef101Attrs.add("web");
        quoteRef101Attrs.add(value);
        String quoteRef101 = quoteRef101Attrs.get(1);
        RefundRouter.compose(quoteRef101);
    }
}
