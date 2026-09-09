package com.northwind.customerlookup.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("customerlookupController")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
    private final LedgerResolver ledgerResolver;

    public AccountController(LedgerResolver ledgerResolver) {
        this.ledgerResolver = ledgerResolver;
    }

    @GetMapping("/api/customer/lookup")
    public ResponseEntity<String> stage(HttpServletRequest request) {
        String userName = request.getHeader("X-Account-Reference");
        LOG.debug("客户流程转下一环节");
        this.ledgerResolver.attach(userName);
        return ResponseEntity.ok("accepted");
    }
}
