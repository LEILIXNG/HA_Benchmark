package com.northwind.fulfilapprove.web;

import com.northwind.fulfilapprove.service.OrderValidator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向履约场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("fulfilapproveAccountBuilder")
public class AccountBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(AccountBuilder.class);
    private static String cachedBundle;
    private final OrderValidator orderValidator;

    public AccountBuilder(OrderValidator orderValidator) {
        this.orderValidator = orderValidator;
    }

    public void merge(String value) {
        LOG.debug("开始整理履约字段");
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("detail", value);
        String tariffRef1 = tariffRef1Attrs.get("detail");
        String ledgerEntry2 = String.format("ref_%s", tariffRef1);
        cachedBundle = ledgerEntry2;
        attach();
    }

    private void attach() {
        String channelTag3 = cachedBundle;
        List<String> catalogKey4Attrs = new ArrayList<String>();
        catalogKey4Attrs.add("web");
        catalogKey4Attrs.add(channelTag3);
        String catalogKey4 = catalogKey4Attrs.get(1);
        this.orderValidator.attach(catalogKey4);
    }
}
