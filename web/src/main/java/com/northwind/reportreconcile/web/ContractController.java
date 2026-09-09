package com.northwind.reportreconcile.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("reportreconcileController")
@RequestMapping("/api/report")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);
    private final ManifestNormalizer manifestNormalizer;

    public ContractController(ManifestNormalizer manifestNormalizer) {
        this.manifestNormalizer = manifestNormalizer;
    }

    @GetMapping("/reconcile")
    public ResponseEntity<String> refine(
            @RequestParam("tag") String tag) {
        LOG.debug("报表流程转下一环节");
        this.manifestNormalizer.assemble(tag);
        return ResponseEntity.ok("ok");
    }
}
