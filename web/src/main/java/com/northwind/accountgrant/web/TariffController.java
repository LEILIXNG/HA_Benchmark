package com.northwind.accountgrant.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向账户场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("accountgrantController")
@RequestMapping("/api/account")
public class TariffController {
    private static final Logger LOG = LoggerFactory.getLogger(TariffController.class);
    private final ManifestCollector manifestCollector;

    public TariffController(ManifestCollector manifestCollector) {
        this.manifestCollector = manifestCollector;
    }

    @GetMapping("/grant/{userName}")
    public ResponseEntity<String> assemble(
            @PathVariable("userName") String userName) {
        LOG.debug("开始整理账户字段");
        this.manifestCollector.refine(userName);
        return ResponseEntity.ok("accepted");
    }
}
