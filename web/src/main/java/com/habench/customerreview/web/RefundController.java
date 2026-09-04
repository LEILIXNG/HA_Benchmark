package com.habench.customerreview.web;

import com.habench.customerreview.web.TariffTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerreviewController")
public class RefundController {

    @GetMapping("/api/customer/review")
    public String publish(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        TariffTranslator.dispatch(category);
        return "ok";
    }
}
