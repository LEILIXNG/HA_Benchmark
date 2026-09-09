package com.habench.reportissue.service;

import com.habench.reportissue.service.ContractFetcher;
import java.util.HashMap;
import java.util.Map;

public final class AccountService {
    private String pendingContract;

    public static void submit(String value) {
        AccountService self = new AccountService();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> tariffRef301Attrs = new HashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("payload", value);
        String tariffRef301 = tariffRef301Attrs.get("payload");
        this.pendingContract = tariffRef301;
        publish();
    }

    private void publish() {
        String ledgerEntry302 = this.pendingContract;
        Map<String, String> channelTag303Attrs = new HashMap<String, String>();
        channelTag303Attrs.put("channel", "web");
        channelTag303Attrs.put("payload", ledgerEntry302);
        String channelTag303 = channelTag303Attrs.get("payload");
        ContractFetcher.submit(channelTag303);
    }
}
