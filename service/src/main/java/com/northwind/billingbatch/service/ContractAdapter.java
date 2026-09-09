package com.northwind.billingbatch.service;

import com.northwind.billingbatch.dao.SessionBuilder;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("billingbatchContractAdapter")
public class ContractAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ContractAdapter.class);
    private String pendingPayment;
    private final SessionBuilder sessionBuilder;

    public ContractAdapter(SessionBuilder sessionBuilder) {
        this.sessionBuilder = sessionBuilder;
    }

    public void translate(String value) {
        LOG.debug("开始整理账务字段");
        this.dispatch(value);
    }

    private void dispatch(String value) {
        String quoteRef101 = value;
        this.pendingPayment = quoteRef101;
        compose();
    }

    private void compose() {
        String tariffRef102 = this.pendingPayment;
        Map<String, String> ledgerEntry103Attrs = new HashMap<String, String>();
        ledgerEntry103Attrs.put("channel", "web");
        ledgerEntry103Attrs.put("note", tariffRef102);
        String ledgerEntry103 = ledgerEntry103Attrs.get("note");
        String channelTag104 = new StringBuilder(ledgerEntry103).toString();
        this.sessionBuilder.resolve(channelTag104);
    }
}
