package com.habench.reportassign.web;

import com.habench.reportassign.web.ReceiptNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportassignController")
public class VoucherController {

    @GetMapping("/api/report/assign")
    public String forward(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        ReceiptNormalizer.register(category);
        return "ok";
    }
}
