package com.habench.paymentcapture.web;

import com.habench.paymentcapture.web.TariffFacade;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentcaptureController")
public class ManifestController {

    @GetMapping("/api/payment/capture")
    public String refine(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        TariffFacade.assemble(token);
        return "ok";
    }
}
