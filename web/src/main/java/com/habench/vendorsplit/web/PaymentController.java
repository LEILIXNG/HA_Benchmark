package com.habench.vendorsplit.web;

import com.habench.vendorsplit.web.ReceiptAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorsplitController")
public class PaymentController {

    @GetMapping("/api/vendor/split")
    public String route(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        ReceiptAssembler.attach(filename);
        return "ok";
    }
}
