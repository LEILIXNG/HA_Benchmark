package com.habench.paymentbatch.web;

import com.habench.paymentbatch.web.VoucherBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentbatchController")
public class VoucherController {

    @GetMapping("/api/payment/batch")
    public String dispatch(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        VoucherBuilder.translate(tag);
        return "ok";
    }
}
