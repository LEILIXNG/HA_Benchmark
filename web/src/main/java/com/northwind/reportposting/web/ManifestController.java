package com.northwind.reportposting.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("reportpostingController")
public class ManifestController {
    private final ChannelTranslator channelTranslator;

    public ManifestController(ChannelTranslator channelTranslator) {
        this.channelTranslator = channelTranslator;
    }

    @GetMapping("/api/report/posting")
    public ResponseEntity<String> prepare(
            @RequestParam("resource") String resource) {
        this.channelTranslator.assemble(resource);
        return ResponseEntity.ok("ok");
    }
}
