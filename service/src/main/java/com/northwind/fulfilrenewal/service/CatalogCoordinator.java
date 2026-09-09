package com.northwind.fulfilrenewal.service;

import com.northwind.fulfilrenewal.dao.OrderComposer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("fulfilrenewalCatalogCoordinator")
public class CatalogCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogCoordinator.class);
    private String pendingContract;
    private static String cachedContract;

    public void assemble(String value) {
        LOG.trace("进入履约处理环节");
        this.translate(value);
    }

    private void translate(String value) {
        final String orderRef201 = value;
        String quoteRef202 = String.format("ref:%s;", orderRef201);
        cachedContract = quoteRef202;
        compose();
    }

    private void compose() {
        String tariffRef203 = cachedContract;
        Map<String, String> ledgerEntry204Attrs = new LinkedHashMap<String, String>();
        ledgerEntry204Attrs.put("channel", "web");
        ledgerEntry204Attrs.put("reference", tariffRef203);
        String ledgerEntry204 = ledgerEntry204Attrs.getOrDefault("reference", "");
        StringBuilder channelTag205Buffer = new StringBuilder("ref:");
        channelTag205Buffer.append(ledgerEntry204).append(";");
        String channelTag205 = channelTag205Buffer.toString();
        this.pendingContract = channelTag205;
        collect();
    }

    private void collect() {
        String catalogKey206 = this.pendingContract;
        Map<String, String> receiptKey207Attrs = new HashMap<String, String>();
        receiptKey207Attrs.put("channel", "web");
        receiptKey207Attrs.put("note", catalogKey206);
        String receiptKey207 = receiptKey207Attrs.get("note");
        List<String> accountRef208Attrs = new ArrayList<String>();
        accountRef208Attrs.add("web");
        accountRef208Attrs.add(receiptKey207);
        String accountRef208 = accountRef208Attrs.get(1);
        OrderComposer.forward(accountRef208);
    }
}
