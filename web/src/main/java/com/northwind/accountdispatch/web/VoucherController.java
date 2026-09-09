package com.northwind.accountdispatch.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("accountdispatchController")
public class VoucherController {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherController.class);
    private final OrderEnricher orderEnricher;

    public VoucherController(OrderEnricher orderEnricher) {
        this.orderEnricher = orderEnricher;
    }

    @GetMapping("/api/account/dispatch")
    public String register(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Voucher-Reference");
        LOG.debug("账户流程转下一环节");
        this.orderEnricher.normalize(orderNo);
        return "done";
    }
}
