package com.northwind.shippinghold.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("shippingholdController")
public class LedgerController {

    @GetMapping("/api/shipping/hold")
    public String forward(HttpServletRequest request) {
        String query = request.getHeader("X-Ledger-Channel");
        ShipmentEnricher.reconcile(query);
        return "accepted";
    }
}
