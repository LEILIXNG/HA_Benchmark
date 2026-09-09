package com.northwind.vendorsettle.service;

import com.northwind.vendorsettle.dao.ManifestAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("vendorsettleTariffBroker")
public class TariffBroker {
    private static final Logger LOG = LoggerFactory.getLogger(TariffBroker.class);
    private String pendingLedger;
    private final ManifestAdapter manifestAdapter;

    public TariffBroker(ManifestAdapter manifestAdapter) {
        this.manifestAdapter = manifestAdapter;
    }

    public void merge(String value) {
        LOG.debug("接收到一次供应商处理请求");
        this.stage(value);
    }

    private void stage(String value) {
        String quoteRef101 = value;
        this.pendingLedger = quoteRef101;
        publish();
    }

    private void publish() {
        String tariffRef102 = this.pendingLedger;
        Map<String, String> ledgerEntry103Attrs = new HashMap<String, String>();
        ledgerEntry103Attrs.put("channel", "web");
        ledgerEntry103Attrs.put("note", tariffRef102);
        String ledgerEntry103 = ledgerEntry103Attrs.get("note");
        String channelTag104 = String.format("ref:%s;", ledgerEntry103);
        this.pendingLedger = channelTag104;
        translate();
    }

    private void translate() {
        String catalogKey105 = this.pendingLedger;
        List<String> receiptKey106Attrs = new ArrayList<String>();
        receiptKey106Attrs.add("web");
        receiptKey106Attrs.add(catalogKey105);
        String receiptKey106 = receiptKey106Attrs.get(1);
        this.pendingLedger = receiptKey106;
        attach();
    }

    private void attach() {
        String accountRef107 = this.pendingLedger;
        StringBuilder voucherRef108Buffer = new StringBuilder("ref:");
        voucherRef108Buffer.append(accountRef107).append(";");
        String voucherRef108 = voucherRef108Buffer.toString();
        this.manifestAdapter.register(voucherRef108);
    }
}
