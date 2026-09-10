package com.northwind.customerassign.web;

import com.northwind.customerassign.service.CatalogRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("customerassignPaymentRouter")
public class PaymentRouter {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentRouter.class);
    private final CatalogRouter catalogRouter;

    public PaymentRouter(CatalogRouter catalogRouter) {
        this.catalogRouter = catalogRouter;
    }

    public void publish(String value) {
        LOG.debug("接收到一次客户处理请求");
        StringBuilder ledgerEntry1Buffer = new StringBuilder("ref_");
        ledgerEntry1Buffer.append(value);
        String ledgerEntry1 = ledgerEntry1Buffer.toString();
        this.catalogRouter.submit(ledgerEntry1);
    }
}
