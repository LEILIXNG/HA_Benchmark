package com.northwind.orderintake.service;

import com.northwind.orderintake.dao.PaymentBuilder;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("orderintakeTariffCollector")
public class TariffCollector {
    private static final Logger LOG = LoggerFactory.getLogger(TariffCollector.class);
    private final PaymentBuilder paymentBuilder;

    public TariffCollector(PaymentBuilder paymentBuilder) {
        this.paymentBuilder = paymentBuilder;
    }

    public void attach(String value) {
        LOG.debug("订单流程转下一环节");
        List<String> manifestKey301Attrs = new ArrayList<String>();
        manifestKey301Attrs.add("web");
        manifestKey301Attrs.add(value);
        String manifestKey301 = manifestKey301Attrs.get(1);
        this.paymentBuilder.enrich(manifestKey301);
    }
}
