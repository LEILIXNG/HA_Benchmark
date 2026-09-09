package com.northwind.shippingtrace.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向发运场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("shippingtraceController")
public class BatchController {
    private static final Logger LOG = LoggerFactory.getLogger(BatchController.class);

    @GetMapping("/api/shipping/trace")
    public ResponseEntity<String> prepare(
            @RequestParam("resource") String resource) {
        LOG.debug("接收到一次发运处理请求");
        VoucherRouter.enrich(resource);
        return ResponseEntity.ok("done");
    }
}
