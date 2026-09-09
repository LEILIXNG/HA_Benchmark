package com.northwind.accounthold.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("accountholdController")
@RequestMapping("/api/account")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);

    @GetMapping("/hold")
    public ResponseEntity<String> submit(HttpServletRequest request) {
        String category = request.getHeader("X-Session-Origin");
        LOG.debug("账户流程转下一环节");
        CatalogAdapter.enrich(category);
        return ResponseEntity.ok("done");
    }
}
