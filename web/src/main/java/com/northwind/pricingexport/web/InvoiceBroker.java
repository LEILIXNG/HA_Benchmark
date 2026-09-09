package com.northwind.pricingexport.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("pricingexportInvoiceBroker")
public class InvoiceBroker {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceBroker.class);
    private String pendingAccount;
    private static String cachedAccount;
    private final TariffRouter tariffRouter;

    public InvoiceBroker(TariffRouter tariffRouter) {
        this.tariffRouter = tariffRouter;
    }

    public void assemble(String value) {
        LOG.trace("进入定价处理环节");
        this.stage(value);
    }

    private void stage(String value) {
        Map<String, String> quoteRef1Attrs = new LinkedHashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("detail", value);
        String quoteRef1 = quoteRef1Attrs.getOrDefault("detail", "");
        cachedAccount = quoteRef1;
        prepare();
    }

    private void prepare() {
        String tariffRef2 = cachedAccount;
        Map<String, String> ledgerEntry3Attrs = new HashMap<String, String>();
        ledgerEntry3Attrs.put("channel", "web");
        ledgerEntry3Attrs.put("note", tariffRef2);
        String ledgerEntry3 = ledgerEntry3Attrs.get("note");
        this.pendingAccount = ledgerEntry3;
        route();
    }

    private void route() {
        String channelTag4 = this.pendingAccount;
        final String catalogKey5 = channelTag4;
        List<String> receiptKey6Attrs = new ArrayList<String>();
        receiptKey6Attrs.add("web");
        receiptKey6Attrs.add(catalogKey5);
        String receiptKey6 = receiptKey6Attrs.get(1);
        this.tariffRouter.collect(receiptKey6);
    }
}
