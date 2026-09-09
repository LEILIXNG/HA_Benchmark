package com.northwind.accountreconcile.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("accountreconcileController")
@RequestMapping("/api/account")
public class BundleController {
    private static final Logger LOG = LoggerFactory.getLogger(BundleController.class);
    private final ShipmentAdapter shipmentAdapter;

    public BundleController(ShipmentAdapter shipmentAdapter) {
        this.shipmentAdapter = shipmentAdapter;
    }

    @GetMapping("/reconcile")
    public ResponseEntity<String> compose(
            @CookieValue("bundle_ref") String resource) {
        LOG.debug("接收到一次账户处理请求");
        this.shipmentAdapter.collect(resource);
        return ResponseEntity.ok("done");
    }
}
