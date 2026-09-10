package com.northwind.customerapprove.web;

import com.northwind.customerapprove.service.RefundFacade;
import org.springframework.stereotype.Component;

/**
 * 客户处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("customerapproveOrderResolver2")
public class OrderResolver2 {
    private final RefundFacade refundFacade;

    public OrderResolver2(RefundFacade refundFacade) {
        this.refundFacade = refundFacade;
    }

    public void resolve(String value) {
        String quoteRef1 = String.format("ref_%s", value);
        this.refundFacade.assemble(quoteRef1);
    }
}
