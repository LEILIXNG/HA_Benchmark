package com.northwind.customermerge.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向客户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("customermergeController")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
    private final CatalogService catalogService;

    public AccountController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/api/customer/merge")
    public String dispatch(HttpServletRequest request) {
        String query = request.getHeader("X-Account-Origin");
        LOG.debug("接收到一次客户处理请求");
        this.catalogService.dispatch(query);
        return "ok";
    }
}
