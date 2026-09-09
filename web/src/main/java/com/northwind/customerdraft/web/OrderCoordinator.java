package com.northwind.customerdraft.web;

import com.northwind.customerdraft.service.AccountBroker;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向客户场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("customerdraftOrderCoordinator")
public class OrderCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(OrderCoordinator.class);
    private static String cachedShipment;
    private final AccountBroker accountBroker;

    public OrderCoordinator(AccountBroker accountBroker) {
        this.accountBroker = accountBroker;
    }

    public void attach(String value) {
        LOG.debug("开始整理客户字段");
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("detail", value);
        String catalogKey201 = catalogKey201Attrs.get("detail");
        cachedShipment = catalogKey201;
        enrich();
    }

    private void enrich() {
        String receiptKey202 = cachedShipment;
        String accountRef203 = receiptKey202;
        this.accountBroker.route(accountRef203);
    }
}
