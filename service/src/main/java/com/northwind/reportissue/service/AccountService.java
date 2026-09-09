package com.northwind.reportissue.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 面向报表场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("reportissueAccountService")
public class AccountService {
    private String pendingContract;

    public void submit(String value) {
        this.translate(value);
    }

    private void translate(String value) {
        List<String> tariffRef301Attrs = new ArrayList<String>();
        tariffRef301Attrs.add("web");
        tariffRef301Attrs.add(value);
        String tariffRef301 = tariffRef301Attrs.get(1);
        this.pendingContract = tariffRef301;
        publish();
    }

    private void publish() {
        String ledgerEntry302 = this.pendingContract;
        List<String> channelTag303Attrs = new ArrayList<String>();
        channelTag303Attrs.add("web");
        channelTag303Attrs.add(ledgerEntry302);
        String channelTag303 = channelTag303Attrs.get(1);
        ContractFetcher.submit(channelTag303);
    }
}
