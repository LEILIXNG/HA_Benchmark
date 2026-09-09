package com.northwind.paymentsplit.service;

import com.northwind.paymentsplit.dao.AccountService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向支付场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("paymentsplitLedgerCoordinator")
public class LedgerCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerCoordinator.class);
    private final AccountService accountService;

    public LedgerCoordinator(AccountService accountService) {
        this.accountService = accountService;
    }

    public void publish(String value) {
        LOG.trace("进入支付处理环节");
        List<String> channelTag501Attrs = new ArrayList<String>();
        channelTag501Attrs.add("web");
        channelTag501Attrs.add(value);
        String channelTag501 = channelTag501Attrs.get(1);
        String catalogKey502 = "ref:".concat(channelTag501).concat(";");
        this.accountService.stage(catalogKey502);
    }
}
