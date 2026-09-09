package com.northwind.reportmanifest.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向报表场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("reportmanifestController")
public class RefundController {
    private static final Logger LOG = LoggerFactory.getLogger(RefundController.class);

    @GetMapping("/api/report/manifest")
    public ResponseEntity<String> assemble(
            @RequestParam("query") String query) {
        LOG.trace("进入报表处理环节");
        ChannelCollector.forward(query);
        return ResponseEntity.ok("ok");
    }
}
