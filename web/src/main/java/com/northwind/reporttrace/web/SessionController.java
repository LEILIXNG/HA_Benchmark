package com.northwind.reporttrace.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("reporttraceController")
@RequestMapping("/api/report")
public class SessionController {
    private static final Logger LOG = LoggerFactory.getLogger(SessionController.class);
    private final BatchResolver batchResolver;

    public SessionController(BatchResolver batchResolver) {
        this.batchResolver = batchResolver;
    }

    @GetMapping("/trace")
    public String enrich(
            @RequestParam("keyword") String keyword) {
        LOG.debug("报表流程转下一环节");
        this.batchResolver.publish(keyword);
        return "accepted";
    }
}
