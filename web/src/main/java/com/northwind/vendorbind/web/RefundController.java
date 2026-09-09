package com.northwind.vendorbind.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("vendorbindController")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final TariffEnricher tariffEnricher;

    public RefundController(TariffEnricher tariffEnricher) {
        this.tariffEnricher = tariffEnricher;
    }

    @GetMapping("/api/vendor/bind")
    public ResponseEntity<String> refine(
            @RequestParam("filename") String filename) {
        LOG.debug("供应商流程转下一环节");
        this.tariffEnricher.translate(filename);
        return ResponseEntity.ok("ok");
    }
}
