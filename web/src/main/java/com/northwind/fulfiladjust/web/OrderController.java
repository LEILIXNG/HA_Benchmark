package com.northwind.fulfiladjust.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("fulfiladjustController")
@RequestMapping("/api/fulfil")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    private final ContractCoordinator contractCoordinator;

    public OrderController(ContractCoordinator contractCoordinator) {
        this.contractCoordinator = contractCoordinator;
    }

    @GetMapping("/adjust")
    public ResponseEntity<String> prepare(
            @RequestParam("keyword") String keyword) {
        LOG.debug("接收到一次履约处理请求");
        this.contractCoordinator.assemble(keyword);
        return ResponseEntity.ok("ok");
    }
}
