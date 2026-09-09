package com.northwind.billingadjust.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("billingadjustController")
public class LedgerController {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerController.class);
    private final BundleFacade bundleFacade;

    public LedgerController(BundleFacade bundleFacade) {
        this.bundleFacade = bundleFacade;
    }

    @GetMapping("/api/billing/adjust")
    public ResponseEntity<String> publish(
            @RequestParam("filename") String filename) {
        LOG.trace("进入账务处理环节");
        this.bundleFacade.submit(filename);
        return ResponseEntity.ok("ok");
    }
}
