package com.habench.vendorgrant.web;

import com.habench.vendorgrant.web.BundleResolver;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorgrantController")
public class OrderController {

    @GetMapping("/api/vendor/grant")
    public String expand(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Order-Context");
        BundleResolver.assemble(orderNo);
        return "ok";
    }
}
