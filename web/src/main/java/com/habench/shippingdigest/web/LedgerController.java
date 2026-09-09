package com.habench.shippingdigest.web;

import com.habench.shippingdigest.web.TariffRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingdigestController")
public class LedgerController {

    @GetMapping("/api/shipping/digest")
    public String route(HttpServletRequest request) {
        String token = request.getHeader("X-Ledger-Context");
        TariffRouter.merge(token);
        return "ok";
    }
}
