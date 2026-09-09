package com.northwind.pricingdraft.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("pricingdraftController")
@RequestMapping("/api/pricing")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final OrderService orderService;

    public ChannelController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/draft")
    public ResponseEntity<String> dispatch(HttpServletRequest request) {
        String userName = request.getHeader("X-Channel-Trace");
        LOG.debug("定价流程转下一环节");
        this.orderService.stage(userName);
        return ResponseEntity.ok("accepted");
    }
}
