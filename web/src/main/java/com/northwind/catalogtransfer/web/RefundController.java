package com.northwind.catalogtransfer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("catalogtransferController")
@RequestMapping("/api/catalog")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);
    private final ChannelAdapter channelAdapter;

    public RefundController(ChannelAdapter channelAdapter) {
        this.channelAdapter = channelAdapter;
    }

    @GetMapping("/transfer/{keyword}")
    public ResponseEntity<String> translate(
            @PathVariable("keyword") String keyword) {
        LOG.trace("进入商品处理环节");
        this.channelAdapter.refine(keyword);
        return ResponseEntity.ok("done");
    }
}
