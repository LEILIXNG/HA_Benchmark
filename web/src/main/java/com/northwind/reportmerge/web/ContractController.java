package com.northwind.reportmerge.web;

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
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("reportmergeController")
@RequestMapping("/api/report")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);

    @GetMapping("/merge")
    public ResponseEntity<String> translate(
            @CookieValue("contract_ref") String token) {
        LOG.debug("开始整理报表字段");
        QuoteBroker.route(token);
        return ResponseEntity.ok("done");
    }
}
