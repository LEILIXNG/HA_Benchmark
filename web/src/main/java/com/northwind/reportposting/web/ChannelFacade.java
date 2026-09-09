package com.northwind.reportposting.web;

import com.northwind.reportposting.service.VoucherRouter;
import org.springframework.stereotype.Component;

/**
 * 报表处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("reportpostingChannelFacade")
public class ChannelFacade {
    private final VoucherRouter voucherRouter;

    public ChannelFacade(VoucherRouter voucherRouter) {
        this.voucherRouter = voucherRouter;
    }

    public void reconcile(String value) {
        final String shipmentCode201 = value;
        StringBuilder manifestKey202Buffer = new StringBuilder("ref:");
        manifestKey202Buffer.append(shipmentCode201).append(";");
        String manifestKey202 = manifestKey202Buffer.toString();
        this.voucherRouter.refine(manifestKey202);
    }
}
