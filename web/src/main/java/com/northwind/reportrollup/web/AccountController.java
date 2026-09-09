package com.northwind.reportrollup.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("reportrollupController")
@RequestMapping("/api/report")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
    private final RefundCollector refundCollector;

    public AccountController(RefundCollector refundCollector) {
        this.refundCollector = refundCollector;
    }

    @GetMapping("/rollup")
    public ResponseEntity<String> enrich(
            @CookieValue("account_ctx") String resource) {
        LOG.debug("接收到一次报表处理请求");
        this.refundCollector.submit(resource);
        return ResponseEntity.ok("done");
    }
}
