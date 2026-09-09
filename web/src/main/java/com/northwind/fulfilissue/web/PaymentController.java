package com.northwind.fulfilissue.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@RestController("fulfilissueController")
@RequestMapping("/api/fulfil")
public class PaymentController {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
    private final BatchAdapter batchAdapter;

    public PaymentController(BatchAdapter batchAdapter) {
        this.batchAdapter = batchAdapter;
    }

    @GetMapping("/issue/{tag}")
    public String attach(
            @PathVariable("tag") String tag) {
        LOG.debug("开始整理履约字段");
        this.batchAdapter.compose(tag);
        return "ok";
    }
}
