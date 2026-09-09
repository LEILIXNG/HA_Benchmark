package com.northwind.billingrenewal.service;

import com.northwind.billingrenewal.dao.PaymentAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向账务场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("billingrenewalOrderFacade")
public class OrderFacade {
    private static final Logger LOG = LoggerFactory.getLogger(OrderFacade.class);

    public void prepare(String value) {
        LOG.debug("开始整理账务字段");
        PaymentAssembler.collect(value);
    }
}
