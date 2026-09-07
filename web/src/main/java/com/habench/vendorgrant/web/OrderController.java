package com.habench.vendorgrant.web;

import com.habench.vendorgrant.web.VoucherCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorgrantController")
public class OrderController {

    @GetMapping("/api/vendor/grant")
    public String refine(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        VoucherCoordinator.attach(keyword);
        return "ok";
    }
}
