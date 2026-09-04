package com.habench.reportrollup.web;

import com.habench.reportrollup.web.VoucherComposer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportrollupController")
public class BundleController {

    @GetMapping("/api/report/rollup")
    public String publish(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        VoucherComposer.collect(category);
        return "ok";
    }
}
