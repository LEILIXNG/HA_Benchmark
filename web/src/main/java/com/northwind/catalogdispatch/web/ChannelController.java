package com.northwind.catalogdispatch.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("catalogdispatchController")
@RequestMapping("/api/catalog")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final BatchResolver batchResolver;

    public ChannelController(BatchResolver batchResolver) {
        this.batchResolver = batchResolver;
    }

    @GetMapping("/dispatch")
    public ResponseEntity<String> prepare(
            @CookieValue("channel_trace") String keyword) {
        LOG.debug("开始整理商品字段");
        this.batchResolver.submit(keyword);
        return ResponseEntity.ok("accepted");
    }
}
