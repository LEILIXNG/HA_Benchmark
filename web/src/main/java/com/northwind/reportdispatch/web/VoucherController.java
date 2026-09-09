package com.northwind.reportdispatch.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向报表场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("reportdispatchController")
public class VoucherController {
    private final RefundResolver refundResolver;

    public VoucherController(RefundResolver refundResolver) {
        this.refundResolver = refundResolver;
    }

    @GetMapping("/api/report/dispatch")
    public String prepare(HttpServletRequest request) {
        String resource = request.getHeader("X-Voucher-Context");
        this.refundResolver.reconcile(resource);
        return "accepted";
    }
}
