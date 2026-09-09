package com.northwind.accountarchive.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("accountarchiveController")
@RequestMapping("/api/account")
public class SessionController {
    private final RefundBroker refundBroker;

    public SessionController(RefundBroker refundBroker) {
        this.refundBroker = refundBroker;
    }

    @GetMapping("/archive")
    public String attach(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Session-Context");
        this.refundBroker.route(orderNo);
        return "done";
    }
}
