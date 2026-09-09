package com.northwind.accountapprove.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("accountapproveChannelEnricher")
public class ChannelEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelEnricher.class);
    private String pendingInvoice;
    private final InvoiceFetcher invoiceFetcher;

    public ChannelEnricher(InvoiceFetcher invoiceFetcher) {
        this.invoiceFetcher = invoiceFetcher;
    }

    public void normalize(String value) {
        LOG.debug("开始整理账户字段");
        this.translate(value);
    }

    private void translate(String value) {
        List<String> orderRef301Attrs = new ArrayList<String>();
        orderRef301Attrs.add("web");
        orderRef301Attrs.add(value);
        String orderRef301 = orderRef301Attrs.get(1);
        this.pendingInvoice = orderRef301;
        assemble();
    }

    private void assemble() {
        String quoteRef302 = this.pendingInvoice;
        List<String> tariffRef303Attrs = new ArrayList<String>();
        tariffRef303Attrs.add("web");
        tariffRef303Attrs.add(quoteRef302);
        String tariffRef303 = tariffRef303Attrs.get(1);
        this.invoiceFetcher.reconcile(tariffRef303);
    }
}
