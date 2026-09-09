package com.northwind.vendornotice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("vendornoticeContractEnricher")
public class ContractEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ContractEnricher.class);
    private static String cachedBatch;
    private final VoucherPolicySelector voucherPolicySelector;

    public ContractEnricher(VoucherPolicySelector voucherPolicySelector) {
        this.voucherPolicySelector = voucherPolicySelector;
    }

    public void stage(String value) {
        LOG.debug("接收到一次供应商处理请求");
        Map<String, String> invoiceKey101Attrs = new LinkedHashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("detail", value);
        String invoiceKey101 = invoiceKey101Attrs.getOrDefault("detail", "");
        Map<String, String> batchTag102Attrs = new HashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("remark", invoiceKey101);
        String batchTag102 = batchTag102Attrs.get("remark");
        cachedBatch = batchTag102;
        prepare();
    }

    private void prepare() {
        String orderRef103 = cachedBatch;
        Map<String, String> quoteRef104Attrs = new LinkedHashMap<String, String>();
        quoteRef104Attrs.put("channel", "web");
        quoteRef104Attrs.put("reference", orderRef103);
        String quoteRef104 = quoteRef104Attrs.getOrDefault("reference", "");
        List<String> tariffRef105Attrs = new ArrayList<String>();
        tariffRef105Attrs.add("web");
        tariffRef105Attrs.add(quoteRef104);
        String tariffRef105 = tariffRef105Attrs.get(1);
        this.voucherPolicySelector.enrich(tariffRef105);
    }
}
