package com.northwind.vendorcapture.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@RestController("vendorcaptureController")
public class ShipmentController {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentController.class);
    private final BatchFacade batchFacade;

    public ShipmentController(BatchFacade batchFacade) {
        this.batchFacade = batchFacade;
    }

    @GetMapping("/api/vendor/capture/{target}")
    public ResponseEntity<String> expand(
            @PathVariable("target") String target) {
        LOG.trace("进入供应商处理环节");
        this.batchFacade.reconcile(target);
        return ResponseEntity.ok("done");
    }
}
