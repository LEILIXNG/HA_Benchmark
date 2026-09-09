package com.northwind.orderbind.web;

import com.northwind.orderbind.service.AccountAssembler;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向订单场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("orderbindChannelNormalizer")
public class ChannelNormalizer {
    private final AccountAssembler accountAssembler;

    public ChannelNormalizer(AccountAssembler accountAssembler) {
        this.accountAssembler = accountAssembler;
    }

    public void merge(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("detail", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("detail");
        this.accountAssembler.attach(ledgerEntry1);
    }
}
