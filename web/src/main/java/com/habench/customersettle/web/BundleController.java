package com.habench.customersettle.web;

import com.habench.customersettle.web.BundleTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customersettleController")
public class BundleController {

    @GetMapping("/api/customer/settle")
    public String collect(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        BundleTranslator.register(userName);
        return "ok";
    }
}
