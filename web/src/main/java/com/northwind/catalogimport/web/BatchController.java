package com.northwind.catalogimport.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("catalogimportController")
public class BatchController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchController.class);
    private final ChannelTranslator channelTranslator;

    public BatchController(ChannelTranslator channelTranslator) {
        this.channelTranslator = channelTranslator;
    }

    @GetMapping("/api/catalog/import")
    public ResponseEntity<String> submit(
            @RequestHeader("X-Batch-Channel") String category) {
        LOG.trace("进入商品处理环节");
        this.channelTranslator.normalize(category);
        return ResponseEntity.ok("done");
    }
}
