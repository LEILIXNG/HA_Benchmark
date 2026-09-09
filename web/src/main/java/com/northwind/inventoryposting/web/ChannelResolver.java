package com.northwind.inventoryposting.web;

import com.northwind.inventoryposting.service.RefundRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("inventorypostingChannelResolver")
public class ChannelResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelResolver.class);

    public void prepare(String value) {
        LOG.debug("开始整理库存字段");
        final String accountRef101 = value;
        RefundRouter.reconcile(accountRef101);
    }
}
