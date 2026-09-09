package com.northwind.accountarchive.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 账户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("accountarchiveAccountBuilder")
public class AccountBuilder {
    private String pendingSession;
    private final SessionLoader sessionLoader;

    public AccountBuilder(SessionLoader sessionLoader) {
        this.sessionLoader = sessionLoader;
    }

    public void register(String value) {
        this.enrich(value);
    }

    private void enrich(String value) {
        List<String> tariffRef401Attrs = new ArrayList<String>();
        tariffRef401Attrs.add("web");
        tariffRef401Attrs.add(value);
        String tariffRef401 = tariffRef401Attrs.get(1);
        this.pendingSession = tariffRef401;
        stage();
    }

    private void stage() {
        String ledgerEntry402 = this.pendingSession;
        Map<String, String> channelTag403Attrs = new LinkedHashMap<String, String>();
        channelTag403Attrs.put("channel", "web");
        channelTag403Attrs.put("note", ledgerEntry402);
        String channelTag403 = channelTag403Attrs.getOrDefault("note", "");
        this.sessionLoader.reconcile(channelTag403);
    }
}
