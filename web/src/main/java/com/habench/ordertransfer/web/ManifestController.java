package com.habench.ordertransfer.web;

import com.habench.ordertransfer.web.TariffFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordertransferController")
public class ManifestController {

    @GetMapping("/api/order/transfer")
    public String assemble(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        TariffFacade.resolve(label);
        return "ok";
    }
}
