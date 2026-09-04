package com.habench.reportrenewal.web;

import com.habench.reportrenewal.web.BatchRouter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportrenewalController")
public class PaymentController {

    @GetMapping("/api/report/renewal")
    public String submit(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        BatchRouter.merge(filename);
        return "ok";
    }
}
