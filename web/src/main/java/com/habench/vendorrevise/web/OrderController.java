package com.habench.vendorrevise.web;

import com.habench.vendorrevise.web.ReceiptTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorreviseController")
public class OrderController {

    @GetMapping("/api/vendor/revise")
    public String prepare(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        ReceiptTranslator.submit(filename);
        return "ok";
    }
}
