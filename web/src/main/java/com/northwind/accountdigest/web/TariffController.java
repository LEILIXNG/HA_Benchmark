package com.northwind.accountdigest.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账户场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("accountdigestController")
public class TariffController {
    private static final Logger LOG = LoggerFactory.getLogger(TariffController.class);

    @GetMapping("/api/account/digest/{tag}")
    public ResponseEntity<String> reconcile(
            @PathVariable("tag") String tag) {
        LOG.debug("开始整理账户字段");
        BatchAdapter.merge(tag);
        return ResponseEntity.ok("accepted");
    }
}
