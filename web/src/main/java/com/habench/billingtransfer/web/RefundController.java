package com.habench.billingtransfer.web;

import com.habench.billingtransfer.web.BatchComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingtransferController")
public class RefundController {

    @GetMapping("/api/billing/transfer")
    public String submit(HttpServletRequest request) {
        String reference = request.getHeader("X-Ha-Payload");
        BatchComposer.route(reference);
        return "ok";
    }
}
