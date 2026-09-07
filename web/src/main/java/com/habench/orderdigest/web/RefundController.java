package com.habench.orderdigest.web;

import com.habench.orderdigest.web.QuoteAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderdigestController")
public class RefundController {

    @GetMapping("/api/order/digest")
    public String prepare(HttpServletRequest request) {
        String target = request.getHeader("X-Ha-Payload");
        QuoteAssembler.resolve(target);
        return "ok";
    }
}
