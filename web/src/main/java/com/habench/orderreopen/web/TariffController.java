package com.habench.orderreopen.web;

import com.habench.orderreopen.web.AccountNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderreopenController")
public class TariffController {

    @GetMapping("/api/order/reopen")
    public String submit(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        AccountNormalizer.register(resource);
        return "ok";
    }
}
