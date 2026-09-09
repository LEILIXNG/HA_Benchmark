package com.northwind.reportgrant.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向报表场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("reportgrantController")
@RequestMapping("/api/report")
public class OrderController {
    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/grant")
    public String assemble(
            @RequestParam("resource") String resource) {
        LOG.debug("接收到一次报表处理请求");
        AccountRouter.reconcile(resource);
        return "accepted";
    }
}
