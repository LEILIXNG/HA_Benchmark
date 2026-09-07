package com.habench.reportclose.web;

import com.habench.reportclose.web.SessionRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportcloseController")
public class PaymentController {

    @GetMapping("/api/report/close")
    public String refine(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        SessionRouter.enrich(label);
        return "ok";
    }
}
