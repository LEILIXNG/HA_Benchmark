package com.northwind.fulfilsync.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("fulfilsyncController")
@RequestMapping("/api/fulfil")
public class ShipmentController {

    @GetMapping("/sync")
    public String translate(HttpServletRequest request) {
        String resource = request.getHeader("X-Shipment-Trace");
        LedgerAdapter.enrich(resource);
        return "ok";
    }
}
