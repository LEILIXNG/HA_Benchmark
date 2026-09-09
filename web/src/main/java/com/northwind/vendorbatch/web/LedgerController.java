package com.northwind.vendorbatch.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("vendorbatchController")
public class LedgerController {
    private final OrderRouter orderRouter;

    public LedgerController(OrderRouter orderRouter) {
        this.orderRouter = orderRouter;
    }

    @GetMapping("/api/vendor/batch")
    public String publish(HttpServletRequest request) {
        String userName = request.getHeader("X-Ledger-Context");
        this.orderRouter.dispatch(userName);
        return "ok";
    }
}
