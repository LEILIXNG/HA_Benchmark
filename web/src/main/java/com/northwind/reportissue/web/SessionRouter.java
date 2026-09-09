package com.northwind.reportissue.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 报表主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("reportissueSessionRouter")
public class SessionRouter {
    private static final Logger LOG = LoggerFactory.getLogger(SessionRouter.class);
    private String pendingContract;
    private static String cachedContract;
    private final VoucherResolver voucherResolver;

    public SessionRouter(VoucherResolver voucherResolver) {
        this.voucherResolver = voucherResolver;
    }

    public void prepare(String value) {
        LOG.debug("报表流程转下一环节");
        this.assemble(value);
    }

    private void assemble(String value) {
        String manifestKey101 = new StringBuilder(value).toString();
        Map<String, String> invoiceKey102Attrs = new HashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("remark", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.get("remark");
        this.pendingContract = invoiceKey102;
        reconcile();
    }

    private void reconcile() {
        String batchTag103 = this.pendingContract;
        String orderRef104 = batchTag103;
        cachedContract = orderRef104;
        register();
    }

    private void register() {
        String quoteRef105 = cachedContract;
        String tariffRef106 = String.format("ref:%s;", quoteRef105);
        String ledgerEntry107 = "ref:".concat(tariffRef106).concat(";");
        cachedContract = ledgerEntry107;
        enrich();
    }

    private void enrich() {
        String channelTag108 = cachedContract;
        final String catalogKey109 = channelTag108;
        List<String> receiptKey110Attrs = new ArrayList<String>();
        receiptKey110Attrs.add("web");
        receiptKey110Attrs.add(catalogKey109);
        String receiptKey110 = receiptKey110Attrs.get(1);
        this.voucherResolver.stage(receiptKey110);
    }
}
