package com.northwind.reportquote.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("reportquoteController")
@RequestMapping("/api/report")
public class CatalogController {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogController.class);
    private final LedgerService ledgerService;

    public CatalogController(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    @GetMapping("/quote")
    public String publish(
            @CookieValue("catalog_ref") String resource) {
        LOG.debug("报表流程转下一环节");
        this.ledgerService.register(resource);
        return "ok";
    }
}
