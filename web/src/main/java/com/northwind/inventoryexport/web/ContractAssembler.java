package com.northwind.inventoryexport.web;

import com.northwind.inventoryexport.service.LedgerRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("inventoryexportContractAssembler")
public class ContractAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(ContractAssembler.class);
    private final LedgerRouter ledgerRouter;

    public ContractAssembler(LedgerRouter ledgerRouter) {
        this.ledgerRouter = ledgerRouter;
    }

    public void translate(String value) {
        LOG.debug("接收到一次库存处理请求");
        String quoteRef1 = String.format("ref:%s;", value);
        this.ledgerRouter.route(quoteRef1);
    }
}
