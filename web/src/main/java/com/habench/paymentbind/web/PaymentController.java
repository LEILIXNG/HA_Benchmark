package com.habench.paymentbind.web;

import com.habench.paymentbind.web.VoucherBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentbindController")
public class PaymentController {

    @GetMapping("/api/payment/bind")
    public String submit(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        VoucherBuilder.assemble(category);
        return "ok";
    }
}
