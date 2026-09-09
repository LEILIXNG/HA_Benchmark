package com.northwind.inventoryhold.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("inventoryholdController")
@RequestMapping("/api/inventory")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final AccountCollector accountCollector;

    public BundleController(AccountCollector accountCollector) {
        this.accountCollector = accountCollector;
    }

    @GetMapping("/hold")
    public String register(HttpServletRequest request) {
        String userName = request.getHeader("X-Bundle-Trace");
        LOG.debug("开始整理库存字段");
        this.accountCollector.reconcile(userName);
        return "done";
    }
}
