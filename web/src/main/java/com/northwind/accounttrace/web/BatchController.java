package com.northwind.accounttrace.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("accounttraceController")
public class BatchController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchController.class);
    private final QuoteCoordinator quoteCoordinator;

    public BatchController(QuoteCoordinator quoteCoordinator) {
        this.quoteCoordinator = quoteCoordinator;
    }

    @GetMapping("/api/account/trace/{reference}")
    public ResponseEntity<String> collect(
            @PathVariable("reference") String reference) {
        LOG.trace("进入账户处理环节");
        this.quoteCoordinator.reconcile(reference);
        return ResponseEntity.ok("ok");
    }
}
