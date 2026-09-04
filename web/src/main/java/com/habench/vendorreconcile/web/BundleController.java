package com.habench.vendorreconcile.web;

import com.habench.vendorreconcile.web.OrderCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorreconcileController")
public class BundleController {

    @GetMapping("/api/vendor/reconcile")
    public String dispatch(HttpServletRequest request) {
        String resource = request.getHeader("X-Ha-Payload");
        OrderCollector.register(resource);
        return "ok";
    }
}
