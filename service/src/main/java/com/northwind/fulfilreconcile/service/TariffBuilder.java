package com.northwind.fulfilreconcile.service;

import com.northwind.fulfilreconcile.dao.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("fulfilreconcileTariffBuilder")
public class TariffBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(TariffBuilder.class);
    private final PaymentService paymentService;

    public TariffBuilder(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void expand(String value) {
        LOG.debug("履约流程转下一环节");
        this.paymentService.merge(value);
    }
}
