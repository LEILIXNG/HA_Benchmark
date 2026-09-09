package com.northwind.billinglookup.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账务受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("billinglookupController")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);
    private final BatchBuilder batchBuilder;

    public ContractController(BatchBuilder batchBuilder) {
        this.batchBuilder = batchBuilder;
    }

    @GetMapping("/api/billing/lookup")
    public ResponseEntity<String> register(HttpServletRequest request) {
        String resource = request.getHeader("X-Contract-Correlation");
        LOG.debug("接收到一次账务处理请求");
        this.batchBuilder.refine(resource);
        return ResponseEntity.ok("ok");
    }
}
