package com.northwind.vendorsettle.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 供应商明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("vendorsettleManifestAdapter")
public class ManifestAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestAdapter.class);
    private String pendingLedger;
    private final LedgerRepository ledgerRepository;

    public ManifestAdapter(LedgerRepository ledgerRepository) {
        this.ledgerRepository = ledgerRepository;
    }

    public void register(String value) {
        LOG.debug("接收到一次供应商处理请求");
        this.collect(value);
    }

    private void collect(String value) {
        final String shipmentCode201 = value;
        List<String> manifestKey202Attrs = new ArrayList<String>();
        manifestKey202Attrs.add("web");
        manifestKey202Attrs.add(shipmentCode201);
        String manifestKey202 = manifestKey202Attrs.get(1);
        this.pendingLedger = manifestKey202;
        reconcile();
    }

    private void reconcile() {
        String invoiceKey203 = this.pendingLedger;
        String batchTag204 = "ref:" + invoiceKey203 + ";";
        StringBuilder orderRef205Buffer = new StringBuilder("ref:");
        orderRef205Buffer.append(batchTag204).append(";");
        String orderRef205 = orderRef205Buffer.toString();
        this.ledgerRepository.dispatch(orderRef205);
    }
}
