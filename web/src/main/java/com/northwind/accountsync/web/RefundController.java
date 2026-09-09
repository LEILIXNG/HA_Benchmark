package com.northwind.accountsync.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("accountsyncController")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final ShipmentAssembler shipmentAssembler;

    public RefundController(ShipmentAssembler shipmentAssembler) {
        this.shipmentAssembler = shipmentAssembler;
    }

    @GetMapping("/api/account/sync")
    public String stage(HttpServletRequest request) {
        String userName = request.getHeader("X-Refund-Trace");
        LOG.debug("开始整理账户字段");
        this.shipmentAssembler.translate(userName);
        return "accepted";
    }
}
