package com.northwind.fulfiltransfer.web;

import com.northwind.fulfiltransfer.service.PaymentAdapter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 履约受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("fulfiltransferCatalogComposer")
public class CatalogComposer {
    private static String cachedBundle;

    public void submit(String value) {
        List<String> quoteRef1Attrs = new ArrayList<String>();
        quoteRef1Attrs.add("web");
        quoteRef1Attrs.add(value);
        String quoteRef1 = quoteRef1Attrs.get(1);
        String tariffRef2 = new StringBuilder(quoteRef1).toString();
        cachedBundle = tariffRef2;
        assemble();
    }

    private void assemble() {
        String ledgerEntry3 = cachedBundle;
        String channelTag4 = "ref_".concat(ledgerEntry3);
        PaymentAdapter.translate(channelTag4);
    }
}
