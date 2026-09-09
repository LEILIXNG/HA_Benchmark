package com.northwind.fulfilbatch.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("fulfilbatchController")
public class TariffController {
    private static final Logger LOG = LoggerFactory.getLogger(TariffController.class);
    private final SessionCoordinator sessionCoordinator;

    public TariffController(SessionCoordinator sessionCoordinator) {
        this.sessionCoordinator = sessionCoordinator;
    }

    @GetMapping("/api/fulfil/batch")
    public String enrich(
            @RequestParam("resource") String resource) {
        LOG.debug("开始整理履约字段");
        this.sessionCoordinator.stage(resource);
        return "ok";
    }
}
