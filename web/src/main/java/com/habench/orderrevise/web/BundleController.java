package com.habench.orderrevise.web;

import com.habench.orderrevise.web.SessionRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderreviseController")
public class BundleController {

    @GetMapping("/api/order/revise")
    public String resolve(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        SessionRegistry.compose(keyword);
        return "ok";
    }
}
