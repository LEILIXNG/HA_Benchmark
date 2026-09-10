package com.northwind.billingsync.service;

import com.northwind.billingsync.dao.ChannelFacade;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BundleEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(BundleEnricher.class);
    private String pendingReceipt;

    public static void assemble(String value) {
        LOG.debug("开始整理账务字段");
        BundleEnricher self = new BundleEnricher();
        self.enrich(value);
    }

    private void enrich(String value) {
        StringBuilder orderRef301Buffer = new StringBuilder("ref_");
        orderRef301Buffer.append(value);
        String orderRef301 = orderRef301Buffer.toString();
        String quoteRef302 = "ref_" + orderRef301;
        this.pendingReceipt = quoteRef302;
        compose();
    }

    private void compose() {
        String tariffRef303 = this.pendingReceipt;
        List<String> ledgerEntry304Attrs = new ArrayList<String>();
        ledgerEntry304Attrs.add("web");
        ledgerEntry304Attrs.add(tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get(1);
        ChannelFacade.dispatch(ledgerEntry304);
    }
}
