package com.habench.billingtransfer.web;

import com.habench.billingtransfer.web.TariffFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingtransferController")
public class RefundController {

    @GetMapping("/api/billing/transfer")
    public String register(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        TariffFacade.translate(category);
        return "ok";
    }
}
