package com.northwind.billingdispatch.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("billingdispatchController")
@RequestMapping("/api/billing")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final OrderCoordinator orderCoordinator;

    public ChannelController(OrderCoordinator orderCoordinator) {
        this.orderCoordinator = orderCoordinator;
    }

    @GetMapping("/dispatch")
    public String translate(HttpServletRequest request) {
        String label = request.getHeader("X-Channel-Origin");
        LOG.debug("账务流程转下一环节");
        this.orderCoordinator.stage(label);
        return "ok";
    }
}
