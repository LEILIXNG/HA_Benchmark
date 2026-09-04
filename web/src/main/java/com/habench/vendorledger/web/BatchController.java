package com.habench.vendorledger.web;

import com.habench.vendorledger.web.TariffRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorledgerController")
public class BatchController {

    @GetMapping("/api/vendor/ledger")
    public String dispatch(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        TariffRouter.stage(label);
        return "ok";
    }
}
