package com.northwind.shippingdigest.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发运明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("shippingdigestController")
public class LedgerController {
    private final TariffRouter tariffRouter;

    public LedgerController(TariffRouter tariffRouter) {
        this.tariffRouter = tariffRouter;
    }

    @GetMapping("/api/shipping/digest")
    public ResponseEntity<String> route(HttpServletRequest request) {
        String token = request.getHeader("X-Ledger-Context");
        this.tariffRouter.merge(token);
        return ResponseEntity.ok("ok");
    }
}
