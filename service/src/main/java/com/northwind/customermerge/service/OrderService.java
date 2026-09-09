package com.northwind.customermerge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 客户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("customermergeOrderService")
public class OrderService {
    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);

    public void expand(String value) {
        LOG.debug("开始整理客户字段");
        String tariffRef101 = value;
        OrderRuleSelector.register(tariffRef101);
    }
}
